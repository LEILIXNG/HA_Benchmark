package nw.billingsubmit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingsubmitController")
@RequestMapping("/api/billing")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final CatalogFacade catalogFacade;

    public BatchController(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    @GetMapping("/submit/{label}")
    public String reconcile(
            @PathVariable("label") String label) {
        LOG.debug("接收到一次账务处理请求");
        this.catalogFacade.reconcile(label);
        return "done";
    }
}
