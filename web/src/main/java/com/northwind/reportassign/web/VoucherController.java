package com.northwind.reportassign.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("reportassignController")
@RequestMapping("/api/report")
public class VoucherController {
    private final TariffTranslator tariffTranslator;

    public VoucherController(TariffTranslator tariffTranslator) {
        this.tariffTranslator = tariffTranslator;
    }

    @GetMapping("/assign")
    public String forward(HttpServletRequest request) {
        String category = request.getHeader("X-Voucher-Reference");
        this.tariffTranslator.register(category);
        return "accepted";
    }
}
