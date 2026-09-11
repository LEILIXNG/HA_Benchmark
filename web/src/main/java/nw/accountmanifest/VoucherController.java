package nw.accountmanifest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("accountmanifestController")
public class VoucherController {

    @GetMapping("/api/account/manifest")
    public ResponseEntity<String> attach(
            @RequestParam("keyword") String keyword) {
        BatchAdapter.route(keyword);
        return ResponseEntity.ok("ok");
    }
}
