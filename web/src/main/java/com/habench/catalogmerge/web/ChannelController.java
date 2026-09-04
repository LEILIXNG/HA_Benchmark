package com.habench.catalogmerge.web;

import com.habench.catalogmerge.web.ReceiptCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogmergeController")
public class ChannelController {

    @GetMapping("/api/catalog/merge/{userName}")
    public String attach(
            @PathVariable("userName") String userName) {
        ReceiptCoordinator.stage(userName);
        return "ok";
    }
}
