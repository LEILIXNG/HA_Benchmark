package com.habench.cmdi1020n.web;

import com.habench.cmdi1020n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1020nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1020_n")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
