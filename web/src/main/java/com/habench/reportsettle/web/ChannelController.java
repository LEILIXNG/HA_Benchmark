package com.habench.reportsettle.web;

import com.habench.reportsettle.web.ContractFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsettleController")
public class ChannelController {

    @GetMapping("/api/report/settle/{userName}")
    public String assemble(
            @PathVariable("userName") String userName) {
        ContractFacade.forward(userName);
        return "ok";
    }
}
