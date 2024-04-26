package com.example.RestAPI.controller;

import com.example.RestAPI.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/noticiasereleases")
    public String noticiasereleases(){
        return noticiaService.noticiasereleases();
    }

    @GetMapping("/noticias")
    public String noticias(){
        return noticiaService.noticias();
    }
    @GetMapping("/releases")
    public String releases(){
        return noticiaService.releases();
    }


}
