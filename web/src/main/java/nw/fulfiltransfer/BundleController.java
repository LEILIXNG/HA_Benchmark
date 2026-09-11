package nw.fulfiltransfer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("fulfiltransferController")
public class BundleController {
    private final CatalogComposer catalogComposer;

    public BundleController(CatalogComposer catalogComposer) {
        this.catalogComposer = catalogComposer;
    }

    @GetMapping("/api/fulfil/transfer")
    public ResponseEntity<String> refine(
            @CookieValue("bundle_ctx") String keyword) {
        this.catalogComposer.submit(keyword);
        return ResponseEntity.ok("ok");
    }
}
