package com.habench.path1020.web;

import com.habench.path1020.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1020EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1020")
    public String handle(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        Stage00.apply(orderNo);
        return "ok";
    }
}
