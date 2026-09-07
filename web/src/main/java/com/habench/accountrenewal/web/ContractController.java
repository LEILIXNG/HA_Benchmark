package com.habench.accountrenewal.web;

import com.habench.accountrenewal.web.AccountAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountrenewalController")
public class ContractController {

    @GetMapping("/api/account/renewal/{filename}")
    public String prepare(
            @PathVariable("filename") String filename) {
        AccountAdapter.publish(filename);
        return "ok";
    }
}
