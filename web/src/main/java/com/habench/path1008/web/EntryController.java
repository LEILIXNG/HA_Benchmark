package com.habench.path1008.web;

import com.habench.path1008.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1008EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1008")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.handle(category);
        return "ok";
    }
}
