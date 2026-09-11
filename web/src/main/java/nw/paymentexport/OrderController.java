package nw.paymentexport;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("paymentexportController")
@RequestMapping("/api/payment")
public class OrderController {
    private final CatalogTranslator catalogTranslator;

    public OrderController(CatalogTranslator catalogTranslator) {
        this.catalogTranslator = catalogTranslator;
    }

    @GetMapping("/export")
    public ResponseEntity<String> translate(HttpServletRequest request) {
        String keyword = request.getHeader("X-Order-Channel");
        this.catalogTranslator.register(keyword);
        return ResponseEntity.ok("accepted");
    }
}
