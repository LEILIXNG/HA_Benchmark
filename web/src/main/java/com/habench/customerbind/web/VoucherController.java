package com.habench.customerbind.web;

import com.habench.customerbind.web.ContractFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerbindController")
public class VoucherController {

    @GetMapping("/api/customer/bind")
    public String forward(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ContractFacade.compose(reference);
        return "ok";
    }
}
