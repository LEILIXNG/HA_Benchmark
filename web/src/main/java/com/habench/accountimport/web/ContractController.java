package com.habench.accountimport.web;

import com.habench.accountimport.web.ReceiptRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountimportController")
public class ContractController {

    @GetMapping("/api/account/import")
    public String submit(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        ReceiptRouter.dispatch(filename);
        return "ok";
    }
}
