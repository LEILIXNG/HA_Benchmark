package com.northwind.orderlookup.web;

import com.northwind.orderlookup.service.AccountBuilder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("orderlookupQuoteTranslator")
public class QuoteTranslator {
    private final AccountBuilder accountBuilder;

    public QuoteTranslator(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    public void resolve(String value) {
        List<String> channelTag301Attrs = new ArrayList<String>();
        channelTag301Attrs.add("web");
        channelTag301Attrs.add(value);
        String channelTag301 = channelTag301Attrs.get(1);
        String catalogKey302 = String.valueOf(channelTag301);
        this.accountBuilder.merge(catalogKey302);
    }
}
