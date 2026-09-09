package com.northwind.vendortrace.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("vendortraceController")
public class InvoiceController {

    @GetMapping("/api/vendor/trace/{keyword}")
    public String resolve(
            @PathVariable("keyword") String keyword) {
        TariffAssembler.publish(keyword);
        return "done";
    }
}
