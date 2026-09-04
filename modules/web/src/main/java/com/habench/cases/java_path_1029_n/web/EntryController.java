package com.habench.cases.java_path_1029_n.web;

import com.habench.cases.java_path_1029_n.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1029_nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1029_n")
    public String handle(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        Step00.apply(target);
        return "ok";
    }
}
