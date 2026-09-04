package com.habench.path1012.web;

import com.habench.path1012.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1012EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1012")
    public String handle(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        Stage00.handle(keyword);
        return "ok";
    }
}
