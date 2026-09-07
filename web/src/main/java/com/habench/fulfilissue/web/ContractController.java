package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilissueController")
public class ContractController {

    @GetMapping("/api/fulfil/issue")
    public String refine(
            @RequestParam("tag") String tag) {
        ManifestNormalizer.assemble(tag);
        return "ok";
    }
}
