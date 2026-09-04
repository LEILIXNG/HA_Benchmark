package com.habench.cases.java_path_1019.web;

import com.habench.cases.java_path_1019.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1019EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1019")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Gateway00.apply(filename);
        return "ok";
    }
}
