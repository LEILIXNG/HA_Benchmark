package nw.paymentverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("paymentverifyController")
@RequestMapping("/api/payment")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final ChannelTranslator channelTranslator;

    public InvoiceController(ChannelTranslator channelTranslator) {
        this.channelTranslator = channelTranslator;
    }

    @GetMapping("/verify/{keyword}")
    public ResponseEntity<String> publish(
            @PathVariable("keyword") String keyword) {
        LOG.trace("进入支付处理环节");
        this.channelTranslator.resolve(keyword);
        return ResponseEntity.ok("ok");
    }
}
