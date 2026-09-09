package com.northwind.catalogrefund.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("catalogrefundController")
@RequestMapping("/api/catalog")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final ShipmentRouter shipmentRouter;

    public CatalogController(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    @GetMapping("/refund/{userName}")
    public ResponseEntity<String> dispatch(
            @PathVariable("userName") String userName) {
        LOG.trace("进入商品处理环节");
        this.shipmentRouter.expand(userName);
        return ResponseEntity.ok("accepted");
    }
}
