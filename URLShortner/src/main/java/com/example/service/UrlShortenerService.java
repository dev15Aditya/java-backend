package com.example.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ShortUrl;
import com.example.repository.ShortUrlRepository;

@Service
public class UrlShortenerService {
    @Autowired
    private ShortUrlRepository shortUrlRepository;

    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 6;

    public String shortenUrl(String originalUrl){
        String shortCode;
        
        do{
            shortCode = generateShortCode();
        } while(shortUrlRepository.findByShortCode(shortCode).isPresent());
        
        ShortUrl mapping = new ShortUrl(null, shortCode, originalUrl);
        shortUrlRepository.save(mapping);

        return shortCode;
    }

    public Optional<String> getOriginalUrl(String code){
        return shortUrlRepository.findByShortCode(code).map(ShortUrl::getOriginalUri);
    }

    private String generateShortCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i<LENGTH; i++){
            sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
        }

        return sb.toString();
    }
}
