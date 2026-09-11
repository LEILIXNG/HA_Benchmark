package nw.vendorissue;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("vendorissueController")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final ChannelService channelService;

    public PaymentController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/api/vendor/issue")
    public ResponseEntity<String> refine(HttpServletRequest request) {
        String label = request.getHeader("X-Payment-Reference");
        LOG.debug("供应商流程转下一环节");
        this.channelService.refine(label);
        return ResponseEntity.ok("ok");
    }
}
