package com.habench.cataloghold.web;

import com.habench.cataloghold.web.BatchRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogholdController")
public class BatchController {

    @GetMapping("/api/catalog/hold")
    public String expand(HttpServletRequest request) {
        String token = request.getHeader("X-Batch-Client");
        BatchRegistry.resolve(token);
        return "ok";
    }
}
