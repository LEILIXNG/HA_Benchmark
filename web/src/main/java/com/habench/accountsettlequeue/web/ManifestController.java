package com.habench.accountsettlequeue.web;

import com.habench.accountsettlequeue.web.SessionRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsettlequeueController")
public class ManifestController {

    @GetMapping("/api/account/settlequeue")
    public String submit(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        SessionRegistry.dispatch(userName);
        return "ok";
    }
}
