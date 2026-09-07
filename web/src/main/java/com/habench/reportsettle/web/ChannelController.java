package com.habench.reportsettle.web;

import com.habench.reportsettle.web.ShipmentEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsettleController")
public class ChannelController {

    @GetMapping("/api/report/settle")
    public String route(
            @RequestParam("query") String query) {
        ShipmentEnricher.submit(query);
        return "ok";
    }
}
