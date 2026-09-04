package com.habench.cases.java_path_1006_n.web;

import com.habench.cases.java_path_1006_n.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1006_nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1006_n")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Step00.apply(filename);
        return "ok";
    }
}
