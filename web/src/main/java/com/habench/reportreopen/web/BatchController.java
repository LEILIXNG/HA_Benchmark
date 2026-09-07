package com.habench.reportreopen.web;

import com.habench.reportreopen.web.ChannelCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportreopenController")
public class BatchController {

    @GetMapping("/api/report/reopen/{token}")
    public String submit(
            @PathVariable("token") String token) {
        ChannelCoordinator.prepare(token);
        return "ok";
    }
}
