package com.habench.cmdi1020.web;

import com.habench.cmdi1020.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1020EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1020")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
