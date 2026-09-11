package nw.reportnotice;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("reportnoticeController")
@RequestMapping("/api/report")
public class ReceiptController {
    private final InvoiceBroker invoiceBroker;

    public ReceiptController(InvoiceBroker invoiceBroker) {
        this.invoiceBroker = invoiceBroker;
    }

    @GetMapping("/notice")
    public ResponseEntity<String> forward(HttpServletRequest request) {
        String userName = request.getHeader("X-Receipt-Context");
        this.invoiceBroker.reconcile(userName);
        return ResponseEntity.ok("accepted");
    }
}
