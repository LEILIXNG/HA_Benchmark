package com.habench.vendorverify.web;

import com.habench.vendorverify.web.CatalogAssembler;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorverifyController")
public class ChannelController {

    @GetMapping("/api/vendor/verify")
    public String compose(
            @CookieValue("channel_tag") String target) {
        CatalogAssembler.translate(target);
        return "ok";
    }
}
