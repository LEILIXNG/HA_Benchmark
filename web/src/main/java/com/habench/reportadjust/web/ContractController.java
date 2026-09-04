package com.habench.reportadjust.web;

import com.habench.reportadjust.web.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportadjustController")
public class ContractController {

    @GetMapping("/api/report/adjust/{userName}")
    public String collect(
            @PathVariable("userName") String userName) {
        SessionService.refine(userName);
        return "ok";
    }
}
