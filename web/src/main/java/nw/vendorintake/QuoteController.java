package nw.vendorintake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("vendorintakeController")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    private final AccountTranslator accountTranslator;

    public QuoteController(AccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @GetMapping("/api/vendor/intake")
    public String assemble(
            @RequestHeader("X-Quote-Correlation") String resource) {
        LOG.debug("供应商流程转下一环节");
        this.accountTranslator.forward(resource);
        return "done";
    }
}
