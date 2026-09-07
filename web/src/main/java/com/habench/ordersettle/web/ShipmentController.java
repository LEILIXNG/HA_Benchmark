package com.habench.ordersettle.web;

import com.habench.ordersettle.web.RefundFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersettleController")
public class ShipmentController {

    @GetMapping("/api/order/settle")
    public String normalize(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        RefundFacade.submit(token);
        return "ok";
    }
}
