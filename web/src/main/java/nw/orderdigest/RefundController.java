package nw.orderdigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向订单场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("orderdigestController")
@RequestMapping("/api/order")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final ChannelComposer channelComposer;

    public RefundController(ChannelComposer channelComposer) {
        this.channelComposer = channelComposer;
    }

    @GetMapping("/digest")
    public String assemble(
            @RequestParam("reference") String reference) {
        LOG.trace("进入订单处理环节");
        this.channelComposer.prepare(reference);
        return "ok";
    }
}
