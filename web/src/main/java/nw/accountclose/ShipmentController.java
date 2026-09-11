package nw.accountclose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("accountcloseController")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final InvoiceRouter invoiceRouter;

    public ShipmentController(InvoiceRouter invoiceRouter) {
        this.invoiceRouter = invoiceRouter;
    }

    @GetMapping("/api/account/close")
    public String refine(
            @RequestParam("userName") String userName) {
        LOG.debug("账户流程转下一环节");
        this.invoiceRouter.refine(userName);
        return "ok";
    }
}
