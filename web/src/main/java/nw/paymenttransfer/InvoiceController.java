package nw.paymenttransfer;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("paymenttransferController")
public class InvoiceController {
    private final BatchRouter batchRouter;

    public InvoiceController(BatchRouter batchRouter) {
        this.batchRouter = batchRouter;
    }

    @GetMapping("/api/payment/transfer")
    public String submit(
            @CookieValue("invoice_trace") String reference) {
        this.batchRouter.submit(reference);
        return "accepted";
    }
}
