package com.habench.path1027.web;

import com.habench.path1027.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1027EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1027")
    public String handle(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        Stage00.apply(reference);
        return "ok";
    }
}
