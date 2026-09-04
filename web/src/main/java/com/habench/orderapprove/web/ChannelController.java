package com.habench.orderapprove.web;

import com.habench.orderapprove.web.BundleFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderapproveController")
public class ChannelController {

    @GetMapping("/api/order/approve")
    public String forward(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        BundleFacade.translate(query);
        return "ok";
    }
}
