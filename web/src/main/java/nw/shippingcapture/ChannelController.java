package nw.shippingcapture;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippingcaptureController")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final RefundRegistry refundRegistry;

    public ChannelController(RefundRegistry refundRegistry) {
        this.refundRegistry = refundRegistry;
    }

    @GetMapping("/api/shipping/capture")
    public ResponseEntity<String> merge(HttpServletRequest request) {
        String category = request.getHeader("X-Channel-Trace");
        LOG.debug("接收到一次发运处理请求");
        this.refundRegistry.route(category);
        return ResponseEntity.ok("accepted");
    }
}
