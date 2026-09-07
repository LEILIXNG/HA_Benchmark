package com.habench.vendorsettle.web;

import com.habench.vendorsettle.web.BatchFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsettleController")
public class LedgerController {

    @GetMapping("/api/vendor/settle")
    public String merge(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        BatchFacade.assemble(reference);
        return "ok";
    }
}
