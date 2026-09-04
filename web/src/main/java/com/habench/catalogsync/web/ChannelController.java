package com.habench.catalogsync.web;

import com.habench.catalogsync.web.ChannelRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogsyncController")
public class ChannelController {

    @GetMapping("/api/catalog/sync")
    public String route(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        ChannelRouter.stage(tag);
        return "ok";
    }
}
