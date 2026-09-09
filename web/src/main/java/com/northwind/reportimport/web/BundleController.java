package com.northwind.reportimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("reportimportController")
@RequestMapping("/api/report")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final ContractFacade contractFacade;

    public BundleController(ContractFacade contractFacade) {
        this.contractFacade = contractFacade;
    }

    @GetMapping("/import/{orderNo}")
    public ResponseEntity<String> forward(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("接收到一次报表处理请求");
        this.contractFacade.reconcile(orderNo);
        return ResponseEntity.ok("accepted");
    }
}
