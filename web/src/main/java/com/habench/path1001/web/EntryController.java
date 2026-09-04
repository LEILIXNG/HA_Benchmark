package com.habench.path1001.web;

import com.habench.path1001.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1001EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1001")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
