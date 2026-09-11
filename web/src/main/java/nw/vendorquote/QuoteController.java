package nw.vendorquote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("vendorquoteController")
@RequestMapping("/api/vendor")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    private final VoucherBuilder voucherBuilder;

    public QuoteController(VoucherBuilder voucherBuilder) {
        this.voucherBuilder = voucherBuilder;
    }

    @GetMapping("/quote")
    public String translate(
            @RequestParam("reference") String reference) {
        LOG.debug("接收到一次供应商处理请求");
        this.voucherBuilder.submit(reference);
        return "done";
    }
}
