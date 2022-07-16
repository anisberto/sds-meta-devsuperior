package br.com.anisberto.dsmeta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/servidor")
public class HelloController {

    @GetMapping("/status")
    public ResponseEntity<String> getStatusServer() {
        return ResponseEntity.ok("Servidor esta rodando .... ");
    }
}
