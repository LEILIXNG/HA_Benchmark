package com.habench.customercapture.web;

import com.habench.customercapture.web.RefundFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customercaptureController")
public class RefundController {

    @GetMapping("/api/customer/capture")
    public String merge(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        RefundFacade.refine(filename);
        return "ok";
    }
}
