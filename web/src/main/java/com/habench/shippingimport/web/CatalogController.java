package com.habench.shippingimport.web;

import com.habench.shippingimport.web.SessionFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingimportController")
public class CatalogController {

    @GetMapping("/api/shipping/import/{tag}")
    public String forward(
            @PathVariable("tag") String tag) {
        SessionFacade.normalize(tag);
        return "ok";
    }
}
