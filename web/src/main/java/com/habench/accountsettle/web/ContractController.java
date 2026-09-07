package com.habench.accountsettle.web;

import com.habench.accountsettle.web.ChannelCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsettleController")
public class ContractController {

    @GetMapping("/api/account/settle")
    public String normalize(
            @RequestParam("token") String token) {
        ChannelCoordinator.translate(token);
        return "ok";
    }
}
