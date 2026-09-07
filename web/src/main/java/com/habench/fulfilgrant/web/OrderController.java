package com.habench.fulfilgrant.web;

import com.habench.fulfilgrant.web.VoucherAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilgrantController")
public class OrderController {

    @GetMapping("/api/fulfil/grant")
    public String merge(
            @RequestParam("filename") String filename) {
        VoucherAssembler.resolve(filename);
        return "ok";
    }
}
