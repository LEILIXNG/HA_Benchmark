package com.habench.path1009.web;

import com.habench.path1009.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1009EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1009")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Stage00.apply(keyword);
        return "ok";
    }
}
