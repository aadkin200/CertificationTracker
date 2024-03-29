package com.pgcc.certificationtracker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
public class PublicController {
  @GetMapping("/text")
  public ResponseEntity<String> sendMessage(){
    return new ResponseEntity<>("Hello! this is public API", HttpStatus.OK);
  }
}
