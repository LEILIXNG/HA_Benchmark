package com.northwind.accountsettle.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("accountsettleController")
@RequestMapping("/api/account")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final ChannelCoordinator channelCoordinator;

    public ContractController(ChannelCoordinator channelCoordinator) {
        this.channelCoordinator = channelCoordinator;
    }

    @GetMapping("/settle")
    public String normalize(
            @RequestParam("token") String token) {
        LOG.trace("进入账户处理环节");
        this.channelCoordinator.translate(token);
        return "done";
    }
}
