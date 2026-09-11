package nw.accountassign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("accountassignController")
public class ManifestController {
    private final QuoteAdapter quoteAdapter;

    public ManifestController(QuoteAdapter quoteAdapter) {
        this.quoteAdapter = quoteAdapter;
    }

    @GetMapping("/api/account/assign")
    public ResponseEntity<String> route(
            @RequestParam("target") String target) {
        this.quoteAdapter.compose(target);
        return ResponseEntity.ok("done");
    }
}
