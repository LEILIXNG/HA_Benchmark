package nw.catalogexport;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向商品场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalogexportController")
@RequestMapping("/api/catalog")
public class ShipmentController {
    private final ChannelAdapter channelAdapter;

    public ShipmentController(ChannelAdapter channelAdapter) {
        this.channelAdapter = channelAdapter;
    }

    @GetMapping("/export")
    public String forward(HttpServletRequest request) {
        String token = request.getHeader("X-Shipment-Tenant");
        this.channelAdapter.normalize(token);
        return "accepted";
    }
}
