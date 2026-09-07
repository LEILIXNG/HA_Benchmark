package com.habench.inventorycapture.web;

import com.habench.inventorycapture.web.ContractBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorycaptureController")
public class ChannelController {

    @GetMapping("/api/inventory/capture")
    public String reconcile(
            @RequestParam("query") String query) {
        ContractBuilder.assemble(query);
        return "ok";
    }
}
