package nw.customersettle;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customersettleController")
public class QuoteController {
    private final RefundTranslator refundTranslator;

    public QuoteController(RefundTranslator refundTranslator) {
        this.refundTranslator = refundTranslator;
    }

    @GetMapping("/api/customer/settle")
    public ResponseEntity<String> register(HttpServletRequest request) {
        String resource = request.getHeader("X-Quote-Tenant");
        this.refundTranslator.translate(resource);
        return ResponseEntity.ok("accepted");
    }
}
