package com.northwind.customerbind.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("customerbindController")
@RequestMapping("/api/customer")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final InvoiceNormalizer invoiceNormalizer;

    public ReceiptController(InvoiceNormalizer invoiceNormalizer) {
        this.invoiceNormalizer = invoiceNormalizer;
    }

    @GetMapping("/bind")
    public String merge(HttpServletRequest request) {
        String reference = request.getHeader("X-Receipt-Client");
        LOG.debug("接收到一次客户处理请求");
        this.invoiceNormalizer.compose(reference);
        return "done";
    }
}
