package com.hitha.SpringBootApp1.service;

import com.hitha.SpringBootApp1.repo.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;
    public String getLanguageObject(String languageId) {
        try {
            return languageRepository.findById(languageId);
        }
        catch (RuntimeException e) {
           if (e.getMessage().equals("NOT_FOUND")) {
               throw new RuntimeException("LANGUAGE_OBJECT_NOT_FOUND");
           }
        }
        return languageRepository.findById(languageId);
    }
}
