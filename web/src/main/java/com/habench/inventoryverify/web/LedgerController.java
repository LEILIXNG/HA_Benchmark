package com.habench.inventoryverify.web;

import com.habench.inventoryverify.web.VoucherRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryverifyController")
public class LedgerController {

    @GetMapping("/api/inventory/verify")
    public String submit(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        VoucherRouter.resolve(keyword);
        return "ok";
    }
}
