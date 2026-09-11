package nw.vendorlookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("vendorlookupController")
@RequestMapping("/api/vendor")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final BundleFacade bundleFacade;

    public RefundController(BundleFacade bundleFacade) {
        this.bundleFacade = bundleFacade;
    }

    @GetMapping("/lookup/{query}")
    public ResponseEntity<String> prepare(
            @PathVariable("query") String query) {
        LOG.trace("进入供应商处理环节");
        this.bundleFacade.reconcile(query);
        return ResponseEntity.ok("done");
    }
}
