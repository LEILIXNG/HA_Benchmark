package nw.customerposting;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("customerpostingController")
@RequestMapping("/api/customer")
public class ContractController {

    @GetMapping("/posting")
    public ResponseEntity<String> normalize(
            @CookieValue("contract_ctx") String reference) {
        AccountCoordinator.reconcile(reference);
        return ResponseEntity.ok("accepted");
    }
}
