package com.habench.fulfildigest.web;

import com.habench.fulfildigest.web.TariffService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildigestController")
public class VoucherController {

    @GetMapping("/api/fulfil/digest")
    public String submit(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        TariffService.stage(category);
        return "ok";
    }
}
