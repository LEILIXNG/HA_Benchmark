package nw.billingbind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("billingbindController")
@RequestMapping("/api/billing")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final InvoiceAssembler invoiceAssembler;

    public InvoiceController(InvoiceAssembler invoiceAssembler) {
        this.invoiceAssembler = invoiceAssembler;
    }

    @GetMapping("/bind")
    public String refine(
            @CookieValue("invoice_ctx") String userName) {
        LOG.trace("进入账务处理环节");
        this.invoiceAssembler.reconcile(userName);
        return "done";
    }
}
