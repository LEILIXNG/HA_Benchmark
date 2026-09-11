package nw.pricingsubmit;

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
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("pricingsubmitController")
@RequestMapping("/api/pricing")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);
    private final ChannelCoordinator channelCoordinator;

    public VoucherController(ChannelCoordinator channelCoordinator) {
        this.channelCoordinator = channelCoordinator;
    }

    @GetMapping("/submit/{orderNo}")
    public ResponseEntity<String> attach(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("定价流程转下一环节");
        this.channelCoordinator.route(orderNo);
        return ResponseEntity.ok("ok");
    }
}
