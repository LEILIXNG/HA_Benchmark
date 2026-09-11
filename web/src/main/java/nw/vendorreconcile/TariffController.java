package nw.vendorreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("vendorreconcileController")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);
    private final ChannelBuilder channelBuilder;

    public TariffController(ChannelBuilder channelBuilder) {
        this.channelBuilder = channelBuilder;
    }

    @GetMapping("/api/vendor/reconcile")
    public String attach(
            @RequestParam("orderNo") String orderNo) {
        LOG.debug("开始整理供应商字段");
        this.channelBuilder.publish(orderNo);
        return "ok";
    }
}
