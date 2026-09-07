package com.habench.customerbatch.web;

import com.habench.customerbatch.web.RefundService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerbatchController")
public class BatchController {

    @GetMapping("/api/customer/batch")
    public String expand(
            @RequestParam("target") String target) {
        RefundService.translate(target);
        return "ok";
    }
}
