package nw.pricingmerge;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("pricingmergeController")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final AccountFacade accountFacade;

    public ManifestController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @GetMapping("/api/pricing/merge")
    public String reconcile(HttpServletRequest request) {
        String userName = request.getHeader("X-Manifest-Origin");
        LOG.debug("定价流程转下一环节");
        this.accountFacade.collect(userName);
        return "done";
    }
}
