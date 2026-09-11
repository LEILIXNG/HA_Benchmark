package nw.inventoryledger;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("inventoryledgerController")
public class OrderController {

    @GetMapping("/api/inventory/ledger")
    public ResponseEntity<String> forward(HttpServletRequest request) {
        String keyword = request.getHeader("X-Order-Correlation");
        QuoteTranslator.collect(keyword);
        return ResponseEntity.ok("accepted");
    }
}
