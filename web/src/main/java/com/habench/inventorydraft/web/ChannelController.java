package com.habench.inventorydraft.web;

import com.habench.inventorydraft.web.ReceiptCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydraftController")
public class ChannelController {

    @GetMapping("/api/inventory/draft")
    public String translate(
            @RequestParam("reference") String reference) {
        ReceiptCoordinator.compose(reference);
        return "ok";
    }
}
