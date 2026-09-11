package nw.accountrenewal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("accountrenewalController")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);

    @GetMapping("/api/account/renewal/{filename}")
    public ResponseEntity<String> prepare(
            @PathVariable("filename") String filename) {
        LOG.debug("接收到一次账户处理请求");
        AccountAdapter.publish(filename);
        return ResponseEntity.ok("done");
    }
}
