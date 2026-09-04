package com.habench.path1025.web;

import com.habench.path1025.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1025EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1025")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Stage00.handle(token);
        return "ok";
    }
}
