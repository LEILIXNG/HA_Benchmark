package com.habench.accountverify.web;

import com.habench.accountverify.web.SessionBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountverifyController")
public class BundleController {

    @GetMapping("/api/account/verify")
    public String dispatch(HttpServletRequest request) {
        String filename = request.getHeader("X-Bundle-Context");
        SessionBroker.route(filename);
        return "ok";
    }
}
