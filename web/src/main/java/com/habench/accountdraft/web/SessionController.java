package com.habench.accountdraft.web;

import com.habench.accountdraft.web.AccountRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountdraftController")
public class SessionController {

    @GetMapping("/api/account/draft")
    public String assemble(HttpServletRequest request) {
        String resource = request.getHeader("X-Session-Tenant");
        AccountRouter.normalize(resource);
        return "ok";
    }
}
