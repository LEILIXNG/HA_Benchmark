package nw.vendorreview;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("vendorreviewController")
public class CatalogController {
    private final InvoiceTranslator invoiceTranslator;

    public CatalogController(InvoiceTranslator invoiceTranslator) {
        this.invoiceTranslator = invoiceTranslator;
    }

    @GetMapping("/api/vendor/review")
    public ResponseEntity<String> submit(HttpServletRequest request) {
        String category = request.getHeader("X-Catalog-Tenant");
        this.invoiceTranslator.refine(category);
        return ResponseEntity.ok("done");
    }
}
