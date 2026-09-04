package com.habench.inventoryassign.web;

import com.habench.inventoryassign.web.TariffRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryassignController")
public class ManifestController {

    @GetMapping("/api/inventory/assign/{keyword}")
    public String expand(
            @PathVariable("keyword") String keyword) {
        TariffRouter.translate(keyword);
        return "ok";
    }
}
