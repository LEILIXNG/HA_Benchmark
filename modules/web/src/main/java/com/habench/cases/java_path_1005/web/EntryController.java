package com.habench.cases.java_path_1005.web;

import com.habench.cases.java_path_1005.service.Sanitizer00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1005EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1005")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Sanitizer00.apply(filename);
        return "ok";
    }
}
