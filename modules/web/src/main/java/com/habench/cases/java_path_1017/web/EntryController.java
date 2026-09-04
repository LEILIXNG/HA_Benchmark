package com.habench.cases.java_path_1017.web;

import com.habench.cases.java_path_1017.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1017EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1017")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Step00.apply(filename);
        return "ok";
    }
}
