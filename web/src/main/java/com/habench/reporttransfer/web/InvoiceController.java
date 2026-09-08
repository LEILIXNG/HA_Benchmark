package com.habench.reporttransfer.web;

import com.habench.reporttransfer.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reporttransferController")
public class InvoiceController {

    @GetMapping("/api/report/transfer")
    public String publish(
            @RequestParam("orderNo") String orderNo) {
        ManifestNormalizer.submit(orderNo);
        return "ok";
    }
}
