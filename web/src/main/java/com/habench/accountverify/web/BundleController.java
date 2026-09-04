package com.habench.accountverify.web;

import com.habench.accountverify.web.ChannelCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountverifyController")
public class BundleController {

    @GetMapping("/api/account/verify/{query}")
    public String submit(
            @PathVariable("query") String query) {
        ChannelCollector.dispatch(query);
        return "ok";
    }
}
