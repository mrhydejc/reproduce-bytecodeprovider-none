package com.example.reproducebytecodeprovidernone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    long id = 0;

    @Autowired
    private EntityHandler handler;

    @GetMapping("/trigger")
    public String trigger() {
        return String.valueOf(handler.trigger());

    }

    @GetMapping("/load")
    public String load() {
        return handler.loadById();
    }
}
