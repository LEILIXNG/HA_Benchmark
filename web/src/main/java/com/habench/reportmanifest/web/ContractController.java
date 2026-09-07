package com.habench.reportmanifest.web;

import com.habench.reportmanifest.web.CatalogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportmanifestController")
public class ContractController {

    @GetMapping("/api/report/manifest")
    public String route(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        CatalogService.dispatch(query);
        return "ok";
    }
}
