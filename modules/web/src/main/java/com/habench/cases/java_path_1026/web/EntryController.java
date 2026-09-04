package com.habench.cases.java_path_1026.web;

import com.habench.cases.java_path_1026.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1026EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1026")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Gateway00.apply(category);
        return "ok";
    }
}
