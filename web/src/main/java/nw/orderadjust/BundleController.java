package nw.orderadjust;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("orderadjustController")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final BatchBroker batchBroker;

    public BundleController(BatchBroker batchBroker) {
        this.batchBroker = batchBroker;
    }

    @GetMapping("/api/order/adjust")
    public ResponseEntity<String> resolve(HttpServletRequest request) {
        String keyword = request.getHeader("X-Bundle-Reference");
        LOG.debug("接收到一次订单处理请求");
        this.batchBroker.collect(keyword);
        return ResponseEntity.ok("ok");
    }
}
