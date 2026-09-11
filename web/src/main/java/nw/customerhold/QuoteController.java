package nw.customerhold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("customerholdController")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);

    @GetMapping("/api/customer/hold")
    public String attach(
            @RequestParam("token") String token) {
        LOG.debug("开始整理客户字段");
        LedgerNormalizer.forward(token);
        return "done";
    }
}
