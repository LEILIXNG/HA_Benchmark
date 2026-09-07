package com.habench.fulfilmerge.web;

import com.habench.fulfilmerge.web.SessionFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilmergeController")
public class CatalogController {

    @GetMapping("/api/fulfil/merge/{tag}")
    public String forward(
            @PathVariable("tag") String tag) {
        SessionFacade.normalize(tag);
        return "ok";
    }
}
