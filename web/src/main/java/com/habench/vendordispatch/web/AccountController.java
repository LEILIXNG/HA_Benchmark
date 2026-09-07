package com.habench.vendordispatch.web;

import com.habench.vendordispatch.web.OrderCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendordispatchController")
public class AccountController {

    @GetMapping("/api/vendor/dispatch/{filename}")
    public String normalize(
            @PathVariable("filename") String filename) {
        OrderCoordinator.prepare(filename);
        return "ok";
    }
}
