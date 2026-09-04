package com.habench.path1002.web;

import com.habench.path1002.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1002EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1002")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Stage00.handle(resource);
        return "ok";
    }
}
