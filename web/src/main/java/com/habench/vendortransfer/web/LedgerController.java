package com.habench.vendortransfer.web;

import com.habench.vendortransfer.web.LedgerTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendortransferController")
public class LedgerController {

    @GetMapping("/api/vendor/transfer")
    public String expand(
            @RequestParam("filename") String filename) {
        LedgerTranslator.resolve(filename);
        return "ok";
    }
}
