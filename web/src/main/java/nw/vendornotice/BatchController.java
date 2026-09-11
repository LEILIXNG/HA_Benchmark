package nw.vendornotice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("vendornoticeController")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final ContractComposer contractComposer;

    public BatchController(ContractComposer contractComposer) {
        this.contractComposer = contractComposer;
    }

    @GetMapping("/api/vendor/notice")
    public String register(
            @CookieValue("batch_ctx") String target) {
        LOG.debug("开始整理供应商字段");
        this.contractComposer.normalize(target);
        return "ok";
    }
}
