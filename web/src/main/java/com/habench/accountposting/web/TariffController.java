package com.habench.accountposting.web;

import com.habench.accountposting.web.TariffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountpostingController")
public class TariffController {

    @GetMapping("/api/account/posting")
    public String prepare(
            @RequestParam("token") String token) {
        TariffService.collect(token);
        return "ok";
    }
}
