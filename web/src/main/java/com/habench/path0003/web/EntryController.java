package com.habench.path0003.web;

import com.habench.path0003.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path0003EntryController")
public class EntryController {

    @GetMapping("/case/java_path_0003")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Stage00.handle(resource);
        return "ok";
    }
}
