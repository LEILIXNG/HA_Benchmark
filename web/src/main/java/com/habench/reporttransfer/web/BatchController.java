package com.habench.reporttransfer.web;

import com.habench.reporttransfer.web.BundleFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reporttransferController")
public class BatchController {

    @GetMapping("/api/report/transfer")
    public String attach(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        BundleFacade.compose(keyword);
        return "ok";
    }
}
