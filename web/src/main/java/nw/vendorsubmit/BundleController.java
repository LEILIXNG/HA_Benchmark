package nw.vendorsubmit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("vendorsubmitController")
@RequestMapping("/api/vendor")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final ContractRouter contractRouter;

    public BundleController(ContractRouter contractRouter) {
        this.contractRouter = contractRouter;
    }

    @GetMapping("/submit/{tag}")
    public String publish(
            @PathVariable("tag") String tag) {
        LOG.debug("供应商流程转下一环节");
        this.contractRouter.enrich(tag);
        return "ok";
    }
}
