package nw.reportrefund;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("reportrefundController")
@RequestMapping("/api/report")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);
    private final InvoiceRouter invoiceRouter;

    public TariffController(InvoiceRouter invoiceRouter) {
        this.invoiceRouter = invoiceRouter;
    }

    @GetMapping("/refund")
    public String refine(
            @RequestHeader("X-Tariff-Reference") String reference) {
        LOG.debug("开始整理报表字段");
        this.invoiceRouter.enrich(reference);
        return "ok";
    }
}
