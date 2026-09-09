package com.northwind.paymentposting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("paymentpostingController")
@RequestMapping("/api/payment")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/posting")
    public String refine(
            @RequestParam("keyword") String keyword) {
        LOG.debug("支付流程转下一环节");
        ContractFacade.assemble(keyword);
        return "accepted";
    }
}
