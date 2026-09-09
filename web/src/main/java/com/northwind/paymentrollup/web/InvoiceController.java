package com.northwind.paymentrollup.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("paymentrollupController")
@RequestMapping("/api/payment")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final ContractNormalizer contractNormalizer;

    public InvoiceController(ContractNormalizer contractNormalizer) {
        this.contractNormalizer = contractNormalizer;
    }

    @GetMapping("/rollup")
    public ResponseEntity<String> expand(HttpServletRequest request) {
        String category = request.getHeader("X-Invoice-Tenant");
        LOG.debug("开始整理支付字段");
        this.contractNormalizer.submit(category);
        return ResponseEntity.ok("ok");
    }
}
