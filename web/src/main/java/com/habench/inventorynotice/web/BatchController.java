package com.habench.inventorynotice.web;

import com.habench.inventorynotice.web.ChannelNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorynoticeController")
public class BatchController {

    @GetMapping("/api/inventory/notice")
    public String translate(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ChannelNormalizer.merge(target);
        return "ok";
    }
}
