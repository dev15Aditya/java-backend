import { Command } from "commander";
import { CacheMethods } from "./cache";
import { startServer } from "./server";

const program = new Command();
const cacheService = new CacheMethods();

program
    .option("--port <number>", "Port to run the proxy on")
    .option("--origin <url>", "Origin server URL")
    .option("--clear-cache", "Clear the cache and exit");

program.parse(process.argv);
const options = program.opts();

if(options.clearCache) {
    cacheService.clearCache();
    console.log("cache cleared.");
    process.exit(0);
}

if(!options.port || !options.origin) {
    console.error("Please provide --port and --origin.");
    process.exit(1);
}

const port = parseInt(options.port, 10);
const origin = options.origin;

startServer(port, origin);