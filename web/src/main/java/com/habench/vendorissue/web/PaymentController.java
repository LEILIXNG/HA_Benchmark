package com.habench.vendorissue.web;

import com.habench.vendorissue.web.ChannelService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorissueController")
public class PaymentController {

    @GetMapping("/api/vendor/issue")
    public String refine(HttpServletRequest request) {
        String label = request.getHeader("X-Payment-Reference");
        ChannelService.refine(label);
        return "ok";
    }
}
