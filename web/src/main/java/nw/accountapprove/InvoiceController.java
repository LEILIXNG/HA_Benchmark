package nw.accountapprove;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("accountapproveController")
public class InvoiceController {
    private final ManifestRegistry manifestRegistry;

    public InvoiceController(ManifestRegistry manifestRegistry) {
        this.manifestRegistry = manifestRegistry;
    }

    @GetMapping("/api/account/approve")
    public String collect(
            @RequestHeader("X-Invoice-Client") String resource) {
        this.manifestRegistry.compose(resource);
        return "accepted";
    }
}
