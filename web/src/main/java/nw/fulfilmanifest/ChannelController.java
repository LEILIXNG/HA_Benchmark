package nw.fulfilmanifest;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("fulfilmanifestController")
@RequestMapping("/api/fulfil")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final ReceiptCoordinator receiptCoordinator;

    public ChannelController(ReceiptCoordinator receiptCoordinator) {
        this.receiptCoordinator = receiptCoordinator;
    }

    @GetMapping("/manifest")
    public String translate(HttpServletRequest request) {
        String reference = request.getHeader("X-Channel-Reference");
        LOG.debug("接收到一次履约处理请求");
        this.receiptCoordinator.normalize(reference);
        return "accepted";
    }
}
