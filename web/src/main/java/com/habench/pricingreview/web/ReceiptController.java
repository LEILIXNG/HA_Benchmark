package com.habench.pricingreview.web;

import com.habench.pricingreview.web.BundleAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreviewController")
public class ReceiptController {

    @GetMapping("/api/pricing/review")
    public String route(HttpServletRequest request) {
        String target = request.getHeader("X-Receipt-Origin");
        BundleAssembler.forward(target);
        return "ok";
    }
}
