package com.habench.inventoryreopen.web;

import com.habench.inventoryreopen.web.TariffFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreopenController")
public class ManifestController {

    @GetMapping("/api/inventory/reopen")
    public String refine(HttpServletRequest request) {
        String token = request.getHeader("X-Manifest-Origin");
        TariffFacade.assemble(token);
        return "ok";
    }
}
