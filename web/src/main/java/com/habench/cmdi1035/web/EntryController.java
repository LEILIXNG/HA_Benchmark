package com.habench.cmdi1035.web;

import com.habench.cmdi1035.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1035EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1035")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
