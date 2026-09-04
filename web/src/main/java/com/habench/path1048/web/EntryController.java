package com.habench.path1048.web;

import com.habench.path1048.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1048EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1048")
    public String handle(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        Stage00.handle(label);
        return "ok";
    }
}
