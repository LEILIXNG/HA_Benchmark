package com.habench.reportnotice.web;

import com.habench.reportnotice.web.ChannelRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportnoticeController")
public class CatalogController {

    @GetMapping("/api/report/notice/{orderNo}")
    public String attach(
            @PathVariable("orderNo") String orderNo) {
        ChannelRouter.normalize(orderNo);
        return "ok";
    }
}
