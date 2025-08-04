import { CachedResponse } from "./types/cache";

const cache = new Map<string, CachedResponse>();

export class CacheMethods {
    getCacheKey = (method: string, url: string) => `${method}: ${url}`;

    getFromCache(key: string): CachedResponse | undefined {
        return cache.get(key);
    }

    saveToCache(key: string, data: CachedResponse) {
        cache.set(key, data);
    }

    clearCache() {
        cache.clear();
    }
}