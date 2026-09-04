package com.habench.path1029.web;

import com.habench.path1029.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1029EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1029")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Stage00.apply(orderNo);
        return "ok";
    }
}
