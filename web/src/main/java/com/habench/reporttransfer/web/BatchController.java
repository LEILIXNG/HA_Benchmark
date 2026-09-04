package com.habench.reporttransfer.web;

import com.habench.reporttransfer.web.CatalogAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reporttransferController")
public class BatchController {

    @GetMapping("/api/report/transfer")
    public String refine(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        CatalogAssembler.submit(target);
        return "ok";
    }
}
