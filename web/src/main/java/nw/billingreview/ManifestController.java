package nw.billingreview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("billingreviewController")
@RequestMapping("/api/billing")
public class ManifestController {
    private final ChannelAssembler channelAssembler;

    public ManifestController(ChannelAssembler channelAssembler) {
        this.channelAssembler = channelAssembler;
    }

    @GetMapping("/review")
    public String publish(
            @RequestParam("category") String category) {
        this.channelAssembler.refine(category);
        return "done";
    }
}
