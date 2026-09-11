package nw.ordermerge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向订单场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("ordermergeController")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final BatchAdapter batchAdapter;

    public ShipmentController(BatchAdapter batchAdapter) {
        this.batchAdapter = batchAdapter;
    }

    @GetMapping("/api/order/merge/{target}")
    public String register(
            @PathVariable("target") String target) {
        LOG.debug("订单流程转下一环节");
        this.batchAdapter.expand(target);
        return "accepted";
    }
}
