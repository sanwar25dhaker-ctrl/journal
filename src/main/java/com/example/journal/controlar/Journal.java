package com.example.journal.controlar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Journal {
    @GetMapping("/ok")
    String fun(){
        return "hello sanwara ";
    }
}
