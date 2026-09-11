package nw.billingassign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingassignController")
public class QuoteController {

    @GetMapping("/api/billing/assign")
    public ResponseEntity<String> dispatch(
            @RequestHeader("X-Quote-Client") String token) {
        ManifestAssembler.dispatch(token);
        return ResponseEntity.ok("done");
    }
}
