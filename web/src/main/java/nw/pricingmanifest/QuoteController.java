package nw.pricingmanifest;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("pricingmanifestController")
@RequestMapping("/api/pricing")
public class QuoteController {
    private final CatalogEnricher catalogEnricher;

    public QuoteController(CatalogEnricher catalogEnricher) {
        this.catalogEnricher = catalogEnricher;
    }

    @GetMapping("/manifest")
    public String enrich(
            @CookieValue("quote_trace") String label) {
        this.catalogEnricher.stage(label);
        return "accepted";
    }
}
