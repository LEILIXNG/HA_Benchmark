package com.habench.billingsettle.web;

import com.habench.billingsettle.web.BundleScreen;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsettleController")
public class LedgerController {

    @GetMapping("/api/billing/settle")
    public String compose(HttpServletRequest request) {
        String label = request.getHeader("X-Ledger-Client");
        BundleScreen.merge(label);
        return "ok";
    }
}
