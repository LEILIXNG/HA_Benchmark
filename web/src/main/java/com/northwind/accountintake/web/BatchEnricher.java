package com.northwind.accountintake.web;

import com.northwind.accountintake.service.ChannelTranslator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountintakeBatchEnricher")
public class BatchEnricher {
    private final ChannelTranslator channelTranslator;

    public BatchEnricher(ChannelTranslator channelTranslator) {
        this.channelTranslator = channelTranslator;
    }

    public void compose(String value) {
        StringBuilder refundCode1Buffer = new StringBuilder("ref:");
        refundCode1Buffer.append(value).append(";");
        String refundCode1 = refundCode1Buffer.toString();
        Map<String, String> shipmentCode2Attrs = new LinkedHashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("remark", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.getOrDefault("remark", "");
        this.channelTranslator.translate(shipmentCode2);
    }
}
