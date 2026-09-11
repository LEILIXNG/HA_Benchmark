package nw.shippinglookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("shippinglookupController")
@RequestMapping("/api/shipping")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);
    private final OrderBroker orderBroker;

    public TariffController(OrderBroker orderBroker) {
        this.orderBroker = orderBroker;
    }

    @GetMapping("/lookup")
    public String resolve(
            @CookieValue("tariff_ref") String query) {
        LOG.debug("开始整理发运字段");
        this.orderBroker.normalize(query);
        return "done";
    }
}
