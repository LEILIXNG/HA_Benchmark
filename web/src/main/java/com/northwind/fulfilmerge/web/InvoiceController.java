package com.northwind.fulfilmerge.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("fulfilmergeController")
@RequestMapping("/api/fulfil")
public class InvoiceController {
    private final ReceiptBuilder receiptBuilder;

    public InvoiceController(ReceiptBuilder receiptBuilder) {
        this.receiptBuilder = receiptBuilder;
    }

    @GetMapping("/merge")
    public ResponseEntity<String> attach(
            @RequestParam("category") String category) {
        this.receiptBuilder.resolve(category);
        return ResponseEntity.ok("ok");
    }
}
