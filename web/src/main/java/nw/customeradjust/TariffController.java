package nw.customeradjust;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customeradjustController")
public class TariffController {
    private final ChannelService channelService;

    public TariffController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/api/customer/adjust")
    public ResponseEntity<String> dispatch(
            @RequestHeader("X-Tariff-Context") String tag) {
        this.channelService.submit(tag);
        return ResponseEntity.ok("ok");
    }
}
