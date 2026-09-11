package nw.catalogsplit;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("catalogsplitController")
@RequestMapping("/api/catalog")
public class AccountController {
    private final ReceiptService receiptService;

    public AccountController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/split")
    public ResponseEntity<String> reconcile(HttpServletRequest request) {
        String filename = request.getHeader("X-Account-Trace");
        this.receiptService.attach(filename);
        return ResponseEntity.ok("ok");
    }
}
