package com.habench.vendornotice.web;

import com.habench.vendornotice.web.ShipmentAdapter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendornoticeController")
public class BatchController {

    @GetMapping("/api/vendor/notice")
    public String assemble(
            @CookieValue("batch_ctx") String target) {
        ShipmentAdapter.translate(target);
        return "ok";
    }
}
