package com.habench.catalogrenewal.web;

import com.habench.catalogrenewal.web.RefundComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogrenewalController")
public class ContractController {

    @GetMapping("/api/catalog/renewal")
    public String assemble(
            @RequestParam("orderNo") String orderNo) {
        RefundComposer.expand(orderNo);
        return "ok";
    }
}
