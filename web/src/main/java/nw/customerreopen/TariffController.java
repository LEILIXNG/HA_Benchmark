package nw.customerreopen;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customerreopenController")
public class TariffController {
    private final ManifestRouter manifestRouter;

    public TariffController(ManifestRouter manifestRouter) {
        this.manifestRouter = manifestRouter;
    }

    @GetMapping("/api/customer/reopen")
    public ResponseEntity<String> route(HttpServletRequest request) {
        String label = request.getHeader("X-Tariff-Tenant");
        this.manifestRouter.compose(label);
        return ResponseEntity.ok("done");
    }
}
