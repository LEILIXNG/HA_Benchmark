package nw.vendorsettle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("vendorsettleController")
@RequestMapping("/api/vendor")
public class LedgerController {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerController.class);
    private final TariffNormalizer tariffNormalizer;

    public LedgerController(TariffNormalizer tariffNormalizer) {
        this.tariffNormalizer = tariffNormalizer;
    }

    @GetMapping("/settle/{target}")
    public String enrich(
            @PathVariable("target") String target) {
        LOG.debug("供应商流程转下一环节");
        this.tariffNormalizer.collect(target);
        return "done";
    }
}
