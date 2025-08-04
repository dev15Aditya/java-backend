# Caching Proxy CLI

A simple CLI tool to start a caching proxy server. It forwards HTTP requests to an origin server and caches the responses. Repeated requests are served from the cache, improving speed and reducing load on the origin server.

---

## 🚀 Features

- Start a caching HTTP proxy server via CLI
- Forwards requests to a given origin server
- Caches responses (GET requests)
- Adds `X-Cache: HIT` or `X-Cache: MISS` header
- In-memory cache (fast & simple)
- Clear the cache via CLI command

---

## Installation

```bash
git clone <your-repo-url>
cd caching-proxy
npm install
```

## Start Server

```bash
npm run dev -- --port <port> --origin <origin-url>
```

## For example
```bash
caching-proxy --port 3000 --origin http://localhost:4200
```

You server will start at port 3000, and when you hit say: `localhost:3000/some-endpoint` you will see `X-Cache: HIT` or `X-Cache: MISS` in header, based on if it's called first time and second.

[![Linkedin](https://i.sstatic.net/gVE0j.png) LinkedIn](https://www.linkedin.com/in/aditya3606/)
&nbsp;