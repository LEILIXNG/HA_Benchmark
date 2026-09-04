package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.ShipmentFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilissueController")
public class ContractController {

    @GetMapping("/api/fulfil/issue/{keyword}")
    public String prepare(
            @PathVariable("keyword") String keyword) {
        ShipmentFacade.enrich(keyword);
        return "ok";
    }
}
