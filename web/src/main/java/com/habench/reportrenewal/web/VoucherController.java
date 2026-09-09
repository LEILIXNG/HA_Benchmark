package com.habench.reportrenewal.web;

import com.habench.reportrenewal.web.TariffEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportrenewalController")
public class VoucherController {

    @GetMapping("/api/report/renewal")
    public String translate(HttpServletRequest request) {
        String query = request.getHeader("X-Voucher-Trace");
        TariffEnricher.forward(query);
        return "ok";
    }
}
