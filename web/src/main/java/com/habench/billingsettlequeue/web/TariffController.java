package com.habench.billingsettlequeue.web;

import com.habench.billingsettlequeue.web.VoucherRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsettlequeueController")
public class TariffController {

    @GetMapping("/api/billing/settlequeue")
    public String forward(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        VoucherRouter.translate(label);
        return "ok";
    }
}
