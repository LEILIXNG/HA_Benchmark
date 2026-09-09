package com.habench.vendorcapture.web;

import com.habench.vendorcapture.web.BatchFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorcaptureController")
public class ShipmentController {

    @GetMapping("/api/vendor/capture/{target}")
    public String expand(
            @PathVariable("target") String target) {
        BatchFacade.reconcile(target);
        return "ok";
    }
}
