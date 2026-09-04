package com.habench.accountissue.web;

import com.habench.accountissue.web.InvoiceAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountissueController")
public class RefundController {

    @GetMapping("/api/account/issue/{filename}")
    public String route(
            @PathVariable("filename") String filename) {
        InvoiceAdapter.collect(filename);
        return "ok";
    }
}
