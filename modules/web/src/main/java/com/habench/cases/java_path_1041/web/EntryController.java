package com.habench.cases.java_path_1041.web;

import com.habench.cases.java_path_1041.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1041EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1041")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Gateway00.apply(resource);
        return "ok";
    }
}
