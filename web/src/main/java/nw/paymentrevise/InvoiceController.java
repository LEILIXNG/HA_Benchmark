package nw.paymentrevise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("paymentreviseController")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final VoucherTranslator voucherTranslator;

    public InvoiceController(VoucherTranslator voucherTranslator) {
        this.voucherTranslator = voucherTranslator;
    }

    @GetMapping("/api/payment/revise")
    public ResponseEntity<String> dispatch(
            @RequestParam("query") String query) {
        LOG.debug("开始整理支付字段");
        this.voucherTranslator.translate(query);
        return ResponseEntity.ok("accepted");
    }
}
