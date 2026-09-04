package com.habench.cmdi1058.web;

import com.habench.cmdi1058.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1058EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1058/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
