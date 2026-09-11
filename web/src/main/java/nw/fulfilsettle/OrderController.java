package nw.fulfilsettle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfilsettleController")
@RequestMapping("/api/fulfil")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final SessionCollector sessionCollector;

    public OrderController(SessionCollector sessionCollector) {
        this.sessionCollector = sessionCollector;
    }

    @GetMapping("/settle/{userName}")
    public String submit(
            @PathVariable("userName") String userName) {
        LOG.debug("履约流程转下一环节");
        this.sessionCollector.merge(userName);
        return "accepted";
    }
}
