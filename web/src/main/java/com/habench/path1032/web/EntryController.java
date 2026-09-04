package com.habench.path1032.web;

import com.habench.path1032.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1032EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1032")
    public String handle(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        Stage00.handle(userName);
        return "ok";
    }
}
