package nw.catalogbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("catalogbatchController")
@RequestMapping("/api/catalog")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final VoucherFacade voucherFacade;

    public AccountController(VoucherFacade voucherFacade) {
        this.voucherFacade = voucherFacade;
    }

    @GetMapping("/batch/{target}")
    public String reconcile(
            @PathVariable("target") String target) {
        LOG.debug("开始整理商品字段");
        this.voucherFacade.publish(target);
        return "accepted";
    }
}
