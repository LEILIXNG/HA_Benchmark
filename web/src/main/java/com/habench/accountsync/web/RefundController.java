package com.habench.accountsync.web;

import com.habench.accountsync.web.ShipmentAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsyncController")
public class RefundController {

    @GetMapping("/api/account/sync")
    public String stage(HttpServletRequest request) {
        String userName = request.getHeader("X-Refund-Trace");
        ShipmentAssembler.translate(userName);
        return "ok";
    }
}
