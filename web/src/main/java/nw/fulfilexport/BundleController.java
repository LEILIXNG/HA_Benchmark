package nw.fulfilexport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfilexportController")
@RequestMapping("/api/fulfil")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final TariffNormalizer tariffNormalizer;

    public BundleController(TariffNormalizer tariffNormalizer) {
        this.tariffNormalizer = tariffNormalizer;
    }

    @GetMapping("/export")
    public String collect(
            @RequestHeader("X-Bundle-Context") String tag) {
        LOG.debug("开始整理履约字段");
        this.tariffNormalizer.translate(tag);
        return "done";
    }
}
