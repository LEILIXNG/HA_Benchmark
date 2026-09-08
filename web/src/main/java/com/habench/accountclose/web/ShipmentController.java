package com.habench.accountclose.web;

import com.habench.accountclose.web.InvoiceRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountcloseController")
public class ShipmentController {

    @GetMapping("/api/account/close")
    public String refine(
            @RequestParam("userName") String userName) {
        InvoiceRouter.refine(userName);
        return "ok";
    }
}
