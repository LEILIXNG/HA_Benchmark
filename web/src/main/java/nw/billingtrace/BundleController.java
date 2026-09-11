package nw.billingtrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingtraceController")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);

    @GetMapping("/api/billing/trace/{userName}")
    public ResponseEntity<String> forward(
            @PathVariable("userName") String userName) {
        LOG.debug("接收到一次账务处理请求");
        PaymentBuilder.compose(userName);
        return ResponseEntity.ok("accepted");
    }
}
