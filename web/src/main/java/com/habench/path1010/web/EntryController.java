package com.habench.path1010.web;

import com.habench.path1010.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1010EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1010")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Stage00.apply(resource);
        return "ok";
    }
}
