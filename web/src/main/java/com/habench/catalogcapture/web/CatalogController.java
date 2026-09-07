package com.habench.catalogcapture.web;

import com.habench.catalogcapture.web.ReceiptCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogcaptureController")
public class CatalogController {

    @GetMapping("/api/catalog/capture/{userName}")
    public String register(
            @PathVariable("userName") String userName) {
        ReceiptCollector.assemble(userName);
        return "ok";
    }
}
