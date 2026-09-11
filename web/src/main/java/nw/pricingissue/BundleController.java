package nw.pricingissue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("pricingissueController")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final CatalogResolver catalogResolver;

    public BundleController(CatalogResolver catalogResolver) {
        this.catalogResolver = catalogResolver;
    }

    @GetMapping("/api/pricing/issue/{resource}")
    public String expand(
            @PathVariable("resource") String resource) {
        LOG.debug("开始整理定价字段");
        this.catalogResolver.dispatch(resource);
        return "accepted";
    }
}
