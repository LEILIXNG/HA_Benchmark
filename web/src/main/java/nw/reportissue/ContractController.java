package nw.reportissue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("reportissueController")
@RequestMapping("/api/report")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final PaymentNormalizer paymentNormalizer;

    public ContractController(PaymentNormalizer paymentNormalizer) {
        this.paymentNormalizer = paymentNormalizer;
    }

    @GetMapping("/issue")
    public String merge(
            @RequestHeader("X-Contract-Tenant") String resource) {
        LOG.trace("进入报表处理环节");
        this.paymentNormalizer.register(resource);
        return "done";
    }
}
