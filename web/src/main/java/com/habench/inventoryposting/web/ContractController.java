package com.habench.inventoryposting.web;

import com.habench.inventoryposting.web.ManifestComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorypostingController")
public class ContractController {

    @GetMapping("/api/inventory/posting")
    public String resolve(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        ManifestComposer.submit(keyword);
        return "ok";
    }
}
