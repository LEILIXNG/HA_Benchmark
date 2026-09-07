package com.habench.reportreview.web;

import com.habench.reportreview.web.BundleBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportreviewController")
public class SessionController {

    @GetMapping("/api/report/review")
    public String enrich(
            @RequestParam("keyword") String keyword) {
        BundleBroker.dispatch(keyword);
        return "ok";
    }
}
