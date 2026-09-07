package com.habench.reportimport.web;

import com.habench.reportimport.web.BatchBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportimportController")
public class BundleController {

    @GetMapping("/api/report/import/{orderNo}")
    public String expand(
            @PathVariable("orderNo") String orderNo) {
        BatchBuilder.expand(orderNo);
        return "ok";
    }
}
