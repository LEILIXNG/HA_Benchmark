package com.northwind.catalogissue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalogissueController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final ShipmentFacade shipmentFacade;

    public RefundController(ShipmentFacade shipmentFacade) {
        this.shipmentFacade = shipmentFacade;
    }

    @GetMapping("/api/catalog/issue")
    public String resolve(
            @RequestParam("token") String token) {
        LOG.debug("商品流程转下一环节");
        this.shipmentFacade.route(token);
        return "done";
    }
}
