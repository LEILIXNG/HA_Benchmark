package com.habench.cases.java_path_1050_n.web;

import com.habench.cases.java_path_1050_n.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1050_nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1050_n")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Gateway00.apply(resource);
        return "ok";
    }
}
