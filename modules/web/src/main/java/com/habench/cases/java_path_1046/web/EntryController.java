package com.habench.cases.java_path_1046.web;

import com.habench.cases.java_path_1046.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1046EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1046")
    public String handle(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        Step00.apply(target);
        return "ok";
    }
}
