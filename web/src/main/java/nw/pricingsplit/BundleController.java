package nw.pricingsplit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("pricingsplitController")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final AccountTranslator accountTranslator;

    public BundleController(AccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @GetMapping("/api/pricing/split")
    public String submit(
            @RequestParam("reference") String reference) {
        LOG.debug("定价流程转下一环节");
        this.accountTranslator.attach(reference);
        return "ok";
    }
}
