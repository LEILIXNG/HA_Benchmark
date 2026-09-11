package nw.catalogrenewal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("catalogrenewalController")
@RequestMapping("/api/catalog")
public class ContractController {
    private final PaymentComposer paymentComposer;

    public ContractController(PaymentComposer paymentComposer) {
        this.paymentComposer = paymentComposer;
    }

    @GetMapping("/renewal/{token}")
    public ResponseEntity<String> submit(
            @PathVariable("token") String token) {
        this.paymentComposer.assemble(token);
        return ResponseEntity.ok("done");
    }
}
