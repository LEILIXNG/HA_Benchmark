package nw.billingquote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingquoteController")
@RequestMapping("/api/billing")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final ContractNormalizer contractNormalizer;

    public SessionController(ContractNormalizer contractNormalizer) {
        this.contractNormalizer = contractNormalizer;
    }

    @GetMapping("/quote/{userName}")
    public String attach(
            @PathVariable("userName") String userName) {
        LOG.trace("进入账务处理环节");
        this.contractNormalizer.refine(userName);
        return "accepted";
    }
}
