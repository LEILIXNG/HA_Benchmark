package nw.reportreopen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("reportreopenController")
@RequestMapping("/api/report")
public class BatchController {
    private final ChannelCoordinator channelCoordinator;

    public BatchController(ChannelCoordinator channelCoordinator) {
        this.channelCoordinator = channelCoordinator;
    }

    @GetMapping("/reopen/{token}")
    public String submit(
            @PathVariable("token") String token) {
        this.channelCoordinator.prepare(token);
        return "accepted";
    }
}
