package com.habench.path1046n.web;

import com.habench.path1046n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1046nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1046_n")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.handle(category);
        return "ok";
    }
}
