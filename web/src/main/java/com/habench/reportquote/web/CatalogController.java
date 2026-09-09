package com.habench.reportquote.web;

import com.habench.reportquote.web.BatchAssembler;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportquoteController")
public class CatalogController {

    @GetMapping("/api/report/quote")
    public String route(
            @CookieValue("catalog_ref") String resource) {
        BatchAssembler.publish(resource);
        return "ok";
    }
}
