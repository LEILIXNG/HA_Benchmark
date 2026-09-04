package com.habench.inventorytransfer.web;

import com.habench.inventorytransfer.web.ReceiptAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorytransferController")
public class ManifestController {

    @GetMapping("/api/inventory/transfer")
    public String forward(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        ReceiptAdapter.refine(orderNo);
        return "ok";
    }
}
