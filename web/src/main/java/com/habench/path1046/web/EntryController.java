package com.habench.path1046.web;

import com.habench.path1046.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1046EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1046")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.handle(category);
        return "ok";
    }
}
