package nw.paymenttrace;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("paymenttraceController")
public class SessionController {
    private final ChannelBuilder channelBuilder;

    public SessionController(ChannelBuilder channelBuilder) {
        this.channelBuilder = channelBuilder;
    }

    @GetMapping("/api/payment/trace")
    public ResponseEntity<String> publish(
            @RequestParam("orderNo") String orderNo) {
        this.channelBuilder.normalize(orderNo);
        return ResponseEntity.ok("accepted");
    }
}
