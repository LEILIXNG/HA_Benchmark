package com.habench.path1000n.web;

import com.habench.path1000n.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1000nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1000_n")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Stage00.apply(category);
        return "ok";
    }
}
