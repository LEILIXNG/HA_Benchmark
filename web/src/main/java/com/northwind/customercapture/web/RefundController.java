package com.northwind.customercapture.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("customercaptureController")
@RequestMapping("/api/customer")
public class RefundController {
    private final RefundFacade refundFacade;

    public RefundController(RefundFacade refundFacade) {
        this.refundFacade = refundFacade;
    }

    @GetMapping("/capture")
    public ResponseEntity<String> merge(HttpServletRequest request) {
        String filename = request.getHeader("X-Refund-Tenant");
        this.refundFacade.refine(filename);
        return ResponseEntity.ok("done");
    }
}
