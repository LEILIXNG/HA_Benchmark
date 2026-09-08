package com.habench.fulfilexport.web;

import com.habench.fulfilexport.web.ChannelNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilexportController")
public class BatchController {

    @GetMapping("/api/fulfil/export")
    public String translate(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ChannelNormalizer.merge(target);
        return "ok";
    }
}
