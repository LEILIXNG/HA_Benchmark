package com.northwind.reportsync.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("reportsyncController")
@RequestMapping("/api/report")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final InvoiceBroker invoiceBroker;

    public RefundController(InvoiceBroker invoiceBroker) {
        this.invoiceBroker = invoiceBroker;
    }

    @GetMapping("/sync")
    public ResponseEntity<String> refine(HttpServletRequest request) {
        String target = request.getHeader("X-Refund-Tenant");
        LOG.trace("进入报表处理环节");
        this.invoiceBroker.publish(target);
        return ResponseEntity.ok("accepted");
    }
}
