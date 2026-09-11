package nw.inventoryrenewal;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("inventoryrenewalController")
public class LedgerController {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerController.class);
    private final QuoteAssembler quoteAssembler;

    public LedgerController(QuoteAssembler quoteAssembler) {
        this.quoteAssembler = quoteAssembler;
    }

    @GetMapping("/api/inventory/renewal")
    public String normalize(HttpServletRequest request) {
        String tag = request.getHeader("X-Ledger-Channel");
        LOG.debug("库存流程转下一环节");
        this.quoteAssembler.prepare(tag);
        return "accepted";
    }
}
