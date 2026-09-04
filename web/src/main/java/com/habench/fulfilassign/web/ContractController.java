package com.habench.fulfilassign.web;

import com.habench.fulfilassign.web.OrderTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilassignController")
public class ContractController {

    @GetMapping("/api/fulfil/assign/{label}")
    public String translate(
            @PathVariable("label") String label) {
        OrderTranslator.dispatch(label);
        return "ok";
    }
}
