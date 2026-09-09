package com.northwind.catalogrenewal.service;

import com.northwind.catalogrenewal.dao.ShipmentRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("catalogrenewalBundleCoordinator")
public class BundleCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator.class);

    public void dispatch(String value) {
        LOG.debug("接收到一次商品处理请求");
        String refundCode401 = value;
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        ShipmentRouter.attach(shipmentCode402);
    }
}
