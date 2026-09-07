package com.habench.customernotice.web;

import com.habench.customernotice.web.BundleAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customernoticeController")
public class RefundController {

    @GetMapping("/api/customer/notice")
    public String submit(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        BundleAdapter.attach(tag);
        return "ok";
    }
}
