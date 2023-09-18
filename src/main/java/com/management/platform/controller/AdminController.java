package com.management.platform.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins ="http://localhost:4200/" )
@RequestMapping(path = "admin")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class AdminController {


    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping
    public String get(){
        return "GET:: admin controller";
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping
    public String post(){
        return "Post:: admin controller";
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping
    public String put(){
        return "Put:: admin controller";
    }


    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping
    public String delete(){
        return "Delete:: admin controller";
    }




}
