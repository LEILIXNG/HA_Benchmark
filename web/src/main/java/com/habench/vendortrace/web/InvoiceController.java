package com.habench.vendortrace.web;

import com.habench.vendortrace.web.TariffAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendortraceController")
public class InvoiceController {

    @GetMapping("/api/vendor/trace/{keyword}")
    public String resolve(
            @PathVariable("keyword") String keyword) {
        TariffAssembler.publish(keyword);
        return "ok";
    }
}
