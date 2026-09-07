package com.habench.reportposting.web;

import com.habench.reportposting.web.CatalogRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportpostingController")
public class ManifestController {

    @GetMapping("/api/report/posting")
    public String refine(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        CatalogRouter.register(category);
        return "ok";
    }
}
