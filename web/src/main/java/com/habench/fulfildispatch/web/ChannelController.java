package com.habench.fulfildispatch.web;

import com.habench.fulfildispatch.web.BatchValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildispatchController")
public class ChannelController {

    @GetMapping("/api/fulfil/dispatch/{userName}")
    public String resolve(
            @PathVariable("userName") String userName) {
        BatchValidator.resolve(userName);
        return "ok";
    }
}
