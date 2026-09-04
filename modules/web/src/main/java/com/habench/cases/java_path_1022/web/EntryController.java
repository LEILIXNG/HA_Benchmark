package com.habench.cases.java_path_1022.web;

import com.habench.cases.java_path_1022.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1022EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1022")
    public String handle(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        Step00.apply(tag);
        return "ok";
    }
}
