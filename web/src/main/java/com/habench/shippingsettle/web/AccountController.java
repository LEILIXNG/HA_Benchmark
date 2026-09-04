package com.habench.shippingsettle.web;

import com.habench.shippingsettle.web.ReceiptNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsettleController")
public class AccountController {

    @GetMapping("/api/shipping/settle")
    public String dispatch(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ReceiptNormalizer.register(category);
        return "ok";
    }
}
