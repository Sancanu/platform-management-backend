package com.management.platform.controller;


import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins ="http://localhost:4200/" )
@RequestMapping(path = "management")
public class ManagementController {

    @GetMapping
    public String get(){
        return "GET:: Manage controller";
    }

    @PostMapping
    public String post(){
        return "Post:: Manage controller";
    }
    @PutMapping
    public String put(){
        return "Put:: Manage controller";
    }


    @DeleteMapping
    public String delete(){
        return "Delete:: Manage controller";
    }

}
