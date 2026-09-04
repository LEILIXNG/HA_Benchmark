package com.habench.reportbatch.web;

import com.habench.reportbatch.web.ReceiptAssembler2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportbatchController")
public class BundleController {

    @GetMapping("/api/report/batch")
    public String register(
            @RequestParam("label") String label) {
        ReceiptAssembler2.submit(label);
        return "ok";
    }
}
