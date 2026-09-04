package com.habench.cases.java_path_1052.web;

import com.habench.cases.java_path_1052.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1052EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1052")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Step00.apply(orderNo);
        return "ok";
    }
}
