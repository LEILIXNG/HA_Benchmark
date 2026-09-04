package com.habench.vendorexport.web;

import com.habench.vendorexport.web.ShipmentComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorexportController")
public class BundleController {

    @GetMapping("/api/vendor/export")
    public String dispatch(
            @RequestParam("target") String target) {
        ShipmentComposer.assemble(target);
        return "ok";
    }
}
