package com.habench.customerreopen.web;

import com.habench.customerreopen.web.ManifestRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerreopenController")
public class TariffController {

    @GetMapping("/api/customer/reopen")
    public String route(HttpServletRequest request) {
        String label = request.getHeader("X-Tariff-Tenant");
        ManifestRouter.compose(label);
        return "ok";
    }
}
