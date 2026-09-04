package com.habench.cases.java_path_1030.web;

import com.habench.cases.java_path_1030.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1030EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1030")
    public String handle(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        Gateway00.apply(tag);
        return "ok";
    }
}
