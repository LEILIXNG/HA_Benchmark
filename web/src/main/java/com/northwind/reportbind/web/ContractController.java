package com.northwind.reportbind.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("reportbindController")
@RequestMapping("/api/report")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final RefundCoordinator refundCoordinator;

    public ContractController(RefundCoordinator refundCoordinator) {
        this.refundCoordinator = refundCoordinator;
    }

    @GetMapping("/bind")
    public ResponseEntity<String> assemble(HttpServletRequest request) {
        String reference = request.getHeader("X-Contract-Channel");
        LOG.debug("接收到一次报表处理请求");
        this.refundCoordinator.assemble(reference);
        return ResponseEntity.ok("ok");
    }
}
