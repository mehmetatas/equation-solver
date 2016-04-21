package net.mehmetatas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mehmet on 20.04.2016.
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World! UPDATED";
    }
}
