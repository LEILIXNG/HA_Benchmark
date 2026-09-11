package nw.accounttransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("accounttransferController")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final ContractComposer contractComposer;

    public ChannelController(ContractComposer contractComposer) {
        this.contractComposer = contractComposer;
    }

    @GetMapping("/api/account/transfer")
    public String compose(
            @RequestParam("userName") String userName) {
        LOG.debug("账户流程转下一环节");
        this.contractComposer.compose(userName);
        return "accepted";
    }
}
