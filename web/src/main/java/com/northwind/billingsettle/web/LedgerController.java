package com.northwind.billingsettle.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("billingsettleController")
public class LedgerController {
    private final BundleScreen bundleScreen;

    public LedgerController(BundleScreen bundleScreen) {
        this.bundleScreen = bundleScreen;
    }

    @GetMapping("/api/billing/settle")
    public String compose(HttpServletRequest request) {
        String label = request.getHeader("X-Ledger-Client");
        this.bundleScreen.merge(label);
        return "done";
    }
}
