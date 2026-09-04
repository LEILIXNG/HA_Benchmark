package com.habench.path1010n.web;

import com.habench.path1010n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1010nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1010_n")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Stage00.apply(resource);
        return "ok";
    }
}
