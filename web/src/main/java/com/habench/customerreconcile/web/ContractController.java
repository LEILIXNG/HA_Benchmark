package com.habench.customerreconcile.web;

import com.habench.customerreconcile.web.SessionRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerreconcileController")
public class ContractController {

    @GetMapping("/api/customer/reconcile")
    public String forward(
            @RequestParam("label") String label) {
        SessionRouter.publish(label);
        return "ok";
    }
}
