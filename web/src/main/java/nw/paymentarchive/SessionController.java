package nw.paymentarchive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("paymentarchiveController")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/api/payment/archive")
    public String normalize(
            @RequestHeader("X-Session-Correlation") String orderNo) {
        LOG.debug("开始整理支付字段");
        BundleAssembler.translate(orderNo);
        return "ok";
    }
}
