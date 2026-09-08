package com.habench.inventorydraft.web;

import com.habench.inventorydraft.web.BundleComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydraftController")
public class InvoiceController {

    @GetMapping("/api/inventory/draft")
    public String assemble(
            @RequestParam("tag") String tag) {
        BundleComposer.attach(tag);
        return "ok";
    }
}
