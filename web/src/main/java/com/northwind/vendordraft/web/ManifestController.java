package com.northwind.vendordraft.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("vendordraftController")
@RequestMapping("/api/vendor")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final BatchAdapter batchAdapter;

    public ManifestController(BatchAdapter batchAdapter) {
        this.batchAdapter = batchAdapter;
    }

    @GetMapping("/draft")
    public String attach(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Manifest-Channel");
        LOG.trace("进入供应商处理环节");
        this.batchAdapter.stage(orderNo);
        return "accepted";
    }
}
