package com.habench.accountsettle.web;

import com.habench.accountsettle.web.CatalogFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsettleController")
public class SessionController {

    @GetMapping("/api/account/settle/{userName}")
    public String collect(
            @PathVariable("userName") String userName) {
        CatalogFacade.register(userName);
        return "ok";
    }
}
