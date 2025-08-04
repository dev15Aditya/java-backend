import express, { Request, Response } from "express";
import { CacheMethods } from "./cache";
import axios from "axios";
import https from 'https';


export function startServer(port: number, origin: string) {
    const app = express();
    const cacheService = new CacheMethods();

    app.use(async (req: Request, res: Response) => {
        const targetUrl = origin + req.url;
        const cacheKey = cacheService.getCacheKey(req.method, req.url);
        const cached = cacheService.getFromCache(cacheKey);

        if (cached) {
            res.set(cached.headers);
            res.set("X-Cache", "HIT");
            res.status(cached.status).send(cached.body);
            return;
        }

        try {
            const response = await axios.request({
                url: targetUrl,
                method: req.method as any,
                headers: req.headers,
                data: req.body,
                httpsAgent: new https.Agent({
                    rejectUnauthorized: false
                })
            })

            const headers = Object.entries(response.headers).reduce((acc, [key, value]) => {
                if (typeof value === "string") acc[key] = value;
                return acc;
            }, {} as Record<string, string>);

            cacheService.saveToCache(cacheKey, {
                status: response.status,
                headers,
                body: response.data
            })

            res.set(headers);
            res.set("X-Cache", "MISS");
            res.set(response.status).send(response.data);
        } catch (err: any) {
            res.status(err.response?.status || 500).send(err.message);
        }
    })

    app.listen(port, () => {
        console.log(`Proxy running on http://localhost:${port}`);
        console.log(`Forwarding requests to ${origin}`);
    });
}