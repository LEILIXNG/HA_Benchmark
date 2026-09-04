package com.habench.shippingassign.web;

import com.habench.shippingassign.web.SessionAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingassignController")
public class ContractController {

    @GetMapping("/api/shipping/assign")
    public String assemble(
            @RequestParam("keyword") String keyword) {
        SessionAssembler.compose(keyword);
        return "ok";
    }
}
