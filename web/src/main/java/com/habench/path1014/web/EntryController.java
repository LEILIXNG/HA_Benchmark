package com.habench.path1014.web;

import com.habench.path1014.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1014EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1014")
    public String handle(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        Stage00.handle(orderNo);
        return "ok";
    }
}
