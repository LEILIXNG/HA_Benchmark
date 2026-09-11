package nw.accountimport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("accountimportController")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final RefundNormalizer refundNormalizer;

    public ContractController(RefundNormalizer refundNormalizer) {
        this.refundNormalizer = refundNormalizer;
    }

    @GetMapping("/api/account/import/{filename}")
    public String publish(
            @PathVariable("filename") String filename) {
        LOG.trace("进入账户处理环节");
        this.refundNormalizer.merge(filename);
        return "ok";
    }
}
