package com.northwind.customerverify.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("customerverifyController")
public class TariffController {

    @GetMapping("/api/customer/verify/{userName}")
    public String compose(
            @PathVariable("userName") String userName) {
        BatchPolicy.prepare(userName);
        return "done";
    }
}
