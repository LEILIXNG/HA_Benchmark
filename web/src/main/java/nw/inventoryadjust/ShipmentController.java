package nw.inventoryadjust;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("inventoryadjustController")
@RequestMapping("/api/inventory")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);

    @GetMapping("/adjust")
    public String refine(
            @RequestHeader("X-Shipment-Origin") String orderNo) {
        LOG.debug("接收到一次库存处理请求");
        ReceiptCollector.collect(orderNo);
        return "ok";
    }
}
