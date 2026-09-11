package nw.accountbind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("accountbindController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final VoucherAdapter voucherAdapter;

    public ReceiptController(VoucherAdapter voucherAdapter) {
        this.voucherAdapter = voucherAdapter;
    }

    @GetMapping("/api/account/bind/{userName}")
    public ResponseEntity<String> stage(
            @PathVariable("userName") String userName) {
        LOG.debug("账户流程转下一环节");
        this.voucherAdapter.publish(userName);
        return ResponseEntity.ok("ok");
    }
}
