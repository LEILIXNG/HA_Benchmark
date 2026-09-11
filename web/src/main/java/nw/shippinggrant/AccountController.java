package nw.shippinggrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippinggrantController")
@RequestMapping("/api/shipping")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/grant")
    public String stage(
            @RequestHeader("X-Account-Correlation") String tag) {
        LOG.trace("进入发运处理环节");
        AccountService.publish(tag);
        return "done";
    }
}
