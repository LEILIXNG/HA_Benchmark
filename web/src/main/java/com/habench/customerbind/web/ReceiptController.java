package com.habench.customerbind.web;

import com.habench.customerbind.web.OrderRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerbindController")
public class ReceiptController {

    @GetMapping("/api/customer/bind")
    public String dispatch(
            @RequestParam("label") String label) {
        OrderRouter.translate(label);
        return "ok";
    }
}
