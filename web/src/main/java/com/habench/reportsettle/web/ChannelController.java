package com.habench.reportsettle.web;

import com.habench.reportsettle.web.ManifestFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsettleController")
public class ChannelController {

    @GetMapping("/api/report/settle")
    public String register(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        ManifestFacade.normalize(tag);
        return "ok";
    }
}
