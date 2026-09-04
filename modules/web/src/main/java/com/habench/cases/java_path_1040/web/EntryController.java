package com.habench.cases.java_path_1040.web;

import com.habench.cases.java_path_1040.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1040EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1040")
    public String handle(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        Gateway00.apply(userName);
        return "ok";
    }
}
