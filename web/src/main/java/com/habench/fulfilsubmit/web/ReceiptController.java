package com.habench.fulfilsubmit.web;

import com.habench.fulfilsubmit.web.ShipmentFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsubmitController")
public class ReceiptController {

    @GetMapping("/api/fulfil/submit/{label}")
    public String forward(
            @PathVariable("label") String label) {
        ShipmentFacade.attach(label);
        return "ok";
    }
}
