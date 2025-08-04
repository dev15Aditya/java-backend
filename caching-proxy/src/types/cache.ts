export type CachedResponse = {
    status: number;
    headers: Record<string, string>;
    body: any;
}