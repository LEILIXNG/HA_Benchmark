package com.habench.catalogreopen.web;

import com.habench.catalogreopen.web.RefundAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreopenController")
public class SessionController {

    @GetMapping("/api/catalog/reopen/{category}")
    public String submit(
            @PathVariable("category") String category) {
        RefundAssembler.refine(category);
        return "ok";
    }
}
