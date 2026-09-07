package com.habench.reportarchive.web;

import com.habench.reportarchive.web.ShipmentFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportarchiveController")
public class SessionController {

    @GetMapping("/api/report/archive")
    public String submit(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        ShipmentFacade.compose(resource);
        return "ok";
    }
}
