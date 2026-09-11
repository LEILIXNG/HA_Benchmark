package nw.accountquote;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("accountquoteController")
public class BatchController {
    private final LedgerBuilder ledgerBuilder;

    public BatchController(LedgerBuilder ledgerBuilder) {
        this.ledgerBuilder = ledgerBuilder;
    }

    @GetMapping("/api/account/quote/{target}")
    public ResponseEntity<String> normalize(
            @PathVariable("target") String target) {
        this.ledgerBuilder.merge(target);
        return ResponseEntity.ok("ok");
    }
}
