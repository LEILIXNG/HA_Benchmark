package com.habench.path1031.web;

import com.habench.path1031.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1031EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1031")
    public String handle(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        Stage00.handle(reference);
        return "ok";
    }
}
