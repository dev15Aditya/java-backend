
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlShortner {
    private static final String base = "abcdefghijklpmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int size = 6;
    private static final String domain = "http://short.js";
    
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private Random rand = new Random();

    private String generateString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<size; i++){
            sb.append(base.charAt(rand.nextInt(base.length())));
        }

        return sb.toString();
    }

    public String shortenUrl(String longUrl) {
        if(longToShort.containsKey(longUrl)) {
            return domain + longToShort.get(longUrl);
        }

        String key;

        do { 
            key = generateString();
        } while (shortToLong.containsKey(key));

        longToShort.put(longUrl, key);
        shortToLong.put(key, longUrl);

        return domain + key;
    }

    public String getLongUrl (String url){
        String shortUrl = url.replace(domain, "");

        return shortToLong.getOrDefault(shortUrl, "URL not found");
    }
}
