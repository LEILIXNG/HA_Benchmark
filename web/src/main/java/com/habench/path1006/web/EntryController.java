package com.habench.path1006.web;

import com.habench.path1006.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1006EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1006")
    public String handle(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        Stage00.handle(tag);
        return "ok";
    }
}
