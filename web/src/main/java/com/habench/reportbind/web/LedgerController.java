package com.habench.reportbind.web;

import com.habench.reportbind.web.ChannelCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportbindController")
public class LedgerController {

    @GetMapping("/api/report/bind")
    public String stage(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        ChannelCollector.submit(filename);
        return "ok";
    }
}
