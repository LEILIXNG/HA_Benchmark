package nw.paymentissue;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("paymentissueController")
@RequestMapping("/api/payment")
public class TariffController {
    private final ManifestCoordinator manifestCoordinator;

    public TariffController(ManifestCoordinator manifestCoordinator) {
        this.manifestCoordinator = manifestCoordinator;
    }

    @GetMapping("/issue")
    public String forward(
            @CookieValue("tariff_token") String token) {
        this.manifestCoordinator.publish(token);
        return "accepted";
    }
}
