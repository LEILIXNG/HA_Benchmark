package nw.pricingrollup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("pricingrollupController")
@RequestMapping("/api/pricing")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final OrderBroker orderBroker;

    public ChannelController(OrderBroker orderBroker) {
        this.orderBroker = orderBroker;
    }

    @GetMapping("/rollup/{orderNo}")
    public ResponseEntity<String> enrich(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("接收到一次定价处理请求");
        this.orderBroker.refine(orderNo);
        return ResponseEntity.ok("accepted");
    }
}
