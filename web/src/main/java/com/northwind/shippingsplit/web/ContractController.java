package com.northwind.shippingsplit.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("shippingsplitController")
@RequestMapping("/api/shipping")
public class ContractController {
    private final BatchService batchService;

    public ContractController(BatchService batchService) {
        this.batchService = batchService;
    }

    @GetMapping("/split/{reference}")
    public String enrich(
            @PathVariable("reference") String reference) {
        this.batchService.assemble(reference);
        return "accepted";
    }
}
