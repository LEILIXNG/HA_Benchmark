package nw.customerbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("customerbatchController")
@RequestMapping("/api/customer")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);

    @GetMapping("/batch")
    public String expand(
            @RequestParam("target") String target) {
        LOG.trace("进入客户处理环节");
        RefundService.translate(target);
        return "accepted";
    }
}
