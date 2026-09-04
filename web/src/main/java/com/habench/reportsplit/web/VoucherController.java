package com.habench.reportsplit.web;

import com.habench.reportsplit.web.ReceiptRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsplitController")
public class VoucherController {

    @GetMapping("/api/report/split")
    public String collect(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ReceiptRouter.assemble(target);
        return "ok";
    }
}
