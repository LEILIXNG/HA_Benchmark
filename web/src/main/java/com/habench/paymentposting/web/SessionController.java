package com.habench.paymentposting.web;

import com.habench.paymentposting.web.ContractFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentpostingController")
public class SessionController {

    @GetMapping("/api/payment/posting")
    public String refine(
            @RequestParam("keyword") String keyword) {
        ContractFacade.assemble(keyword);
        return "ok";
    }
}
