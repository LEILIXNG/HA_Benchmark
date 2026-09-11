package nw.fulfilsplit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向履约场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfilsplitController")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final OrderBroker orderBroker;

    public BatchController(OrderBroker orderBroker) {
        this.orderBroker = orderBroker;
    }

    @GetMapping("/api/fulfil/split")
    public String enrich(
            @RequestParam("token") String token) {
        LOG.trace("进入履约处理环节");
        this.orderBroker.refine(token);
        return "accepted";
    }
}
