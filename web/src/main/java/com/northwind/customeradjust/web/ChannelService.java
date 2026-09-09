package com.northwind.customeradjust.web;

import com.northwind.customeradjust.service.VoucherComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("customeradjustChannelService")
public class ChannelService {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelService.class);

    public void submit(String value) {
        LOG.debug("接收到一次客户处理请求");
        final String voucherRef1 = value;
        VoucherComposer.resolve(voucherRef1);
    }
}
