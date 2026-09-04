package com.habench.cmdi1036.web;

import com.habench.cmdi1036.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1036EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1036/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Stage00.apply(orderNo);
        return "ok";
    }
}
