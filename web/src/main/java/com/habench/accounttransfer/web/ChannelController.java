package com.habench.accounttransfer.web;

import com.habench.accounttransfer.web.ContractComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accounttransferController")
public class ChannelController {

    @GetMapping("/api/account/transfer")
    public String compose(
            @RequestParam("userName") String userName) {
        ContractComposer.compose(userName);
        return "ok";
    }
}
