package com.habench.accounttransfer.web;

import com.habench.accounttransfer.web.BundleAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accounttransferController")
public class CatalogController {

    @GetMapping("/api/account/transfer")
    public String merge(
            @RequestParam("filename") String filename) {
        BundleAssembler.expand(filename);
        return "ok";
    }
}
