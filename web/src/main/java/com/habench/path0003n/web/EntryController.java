package com.habench.path0003n.web;

import com.habench.path0003n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path0003nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_0003_n")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Stage00.handle(resource);
        return "ok";
    }
}
