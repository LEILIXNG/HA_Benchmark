package nw.paymentlookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("paymentlookupController")
@RequestMapping("/api/payment")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final ContractAdapter contractAdapter;

    public SessionController(ContractAdapter contractAdapter) {
        this.contractAdapter = contractAdapter;
    }

    @GetMapping("/lookup/{target}")
    public String register(
            @PathVariable("target") String target) {
        LOG.debug("开始整理支付字段");
        this.contractAdapter.expand(target);
        return "accepted";
    }
}
