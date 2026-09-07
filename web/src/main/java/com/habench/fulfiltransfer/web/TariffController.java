package com.habench.fulfiltransfer.web;

import com.habench.fulfiltransfer.web.SessionBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfiltransferController")
public class TariffController {

    @GetMapping("/api/fulfil/transfer")
    public String dispatch(
            @RequestParam("reference") String reference) {
        SessionBuilder.prepare(reference);
        return "ok";
    }
}
