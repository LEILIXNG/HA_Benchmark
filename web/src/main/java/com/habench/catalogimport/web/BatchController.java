package com.habench.catalogimport.web;

import com.habench.catalogimport.web.ChannelTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogimportController")
public class BatchController {

    @GetMapping("/api/catalog/import")
    public String submit(
            @RequestHeader("X-Batch-Channel") String category) {
        ChannelTranslator.normalize(category);
        return "ok";
    }
}
