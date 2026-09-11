package nw.customersettlequeue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customersettlequeueController")
@RequestMapping("/api/customer")
public class RefundController {
    private final LedgerCoordinator ledgerCoordinator;

    public RefundController(LedgerCoordinator ledgerCoordinator) {
        this.ledgerCoordinator = ledgerCoordinator;
    }

    @GetMapping("/settlequeue/{userName}")
    public ResponseEntity<String> refine(
            @PathVariable("userName") String userName) {
        this.ledgerCoordinator.assemble(userName);
        return ResponseEntity.ok("done");
    }
}
