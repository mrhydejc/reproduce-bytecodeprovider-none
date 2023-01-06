package com.example.reproducebytecodeprovidernone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private EntityHandler handler;

    @GetMapping("/load")
    public String load() {
        return handler.loadById(1);
    }
}
