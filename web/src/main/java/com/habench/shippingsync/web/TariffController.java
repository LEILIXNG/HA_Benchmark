package com.habench.shippingsync.web;

import com.habench.shippingsync.web.OrderNormalizer;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsyncController")
public class TariffController {

    @GetMapping("/api/shipping/sync")
    public String expand(
            @CookieValue("tariff_session") String userName) {
        OrderNormalizer.submit(userName);
        return "ok";
    }
}
