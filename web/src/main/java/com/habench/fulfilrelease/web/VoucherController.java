package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.web.SessionAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreleaseController")
public class VoucherController {

    @GetMapping("/api/fulfil/release")
    public String merge(
            @RequestParam("reference") String reference) {
        SessionAssembler.submit(reference);
        return "ok";
    }
}
