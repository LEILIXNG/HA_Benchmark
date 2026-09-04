package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.web.SessionFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymenttransferController")
public class LedgerController {

    @GetMapping("/api/payment/transfer/{target}")
    public String compose(
            @PathVariable("target") String target) {
        SessionFacade.dispatch(target);
        return "ok";
    }
}
