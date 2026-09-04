package com.habench.catalogrevise.web;

import com.habench.catalogrevise.web.InvoiceFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreviseController")
public class InvoiceController {

    @GetMapping("/api/catalog/revise")
    public String publish(
            @RequestParam("query") String query) {
        InvoiceFacade.forward(query);
        return "ok";
    }
}
