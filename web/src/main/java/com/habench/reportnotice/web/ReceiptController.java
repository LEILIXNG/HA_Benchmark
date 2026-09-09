package com.habench.reportnotice.web;

import com.habench.reportnotice.web.TariffCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportnoticeController")
public class ReceiptController {

    @GetMapping("/api/report/notice")
    public String prepare(HttpServletRequest request) {
        String userName = request.getHeader("X-Receipt-Context");
        TariffCollector.forward(userName);
        return "ok";
    }
}
