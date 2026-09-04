package com.habench.cases.java_path_1008.web;

import com.habench.cases.java_path_1008.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1008EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1008")
    public String handle(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        Step00.apply(query);
        return "ok";
    }
}
