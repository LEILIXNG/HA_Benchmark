package com.habench.fulfiltransfer.web;

import com.habench.fulfiltransfer.web.SessionBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfiltransferController")
public class TariffController {

    @GetMapping("/api/fulfil/transfer")
    public String dispatch(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        SessionBuilder.prepare(orderNo);
        return "ok";
    }
}
