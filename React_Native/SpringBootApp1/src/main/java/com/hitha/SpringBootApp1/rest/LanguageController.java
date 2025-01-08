package com.hitha.SpringBootApp1.rest;

import com.hitha.SpringBootApp1.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    //Get language by id
    @GetMapping("/{languageId}")
    public ResponseEntity<String> getLanguageObject(@PathVariable String languageId) {
        try {
            String currentLanguageObject = languageService.getLanguageObject(languageId);
            return new ResponseEntity<String>(currentLanguageObject,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
