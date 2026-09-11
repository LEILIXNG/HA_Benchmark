package nw.orderhold;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("orderholdController")
public class BundleController {
    private final VoucherBuilder voucherBuilder;

    public BundleController(VoucherBuilder voucherBuilder) {
        this.voucherBuilder = voucherBuilder;
    }

    @GetMapping("/api/order/hold")
    public ResponseEntity<String> reconcile(
            @RequestParam("token") String token) {
        this.voucherBuilder.enrich(token);
        return ResponseEntity.ok("accepted");
    }
}
