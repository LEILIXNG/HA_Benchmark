package com.northwind.billingrollup.web;

import com.northwind.billingrollup.service.ChannelCollector;
import java.util.ArrayList;
import java.util.List;

/**
 * 账务主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountComposer {

    public static void resolve(String value) {
        List<String> tariffRef301Attrs = new ArrayList<String>();
        tariffRef301Attrs.add("web");
        tariffRef301Attrs.add(value);
        String tariffRef301 = tariffRef301Attrs.get(1);
        List<String> ledgerEntry302Attrs = new ArrayList<String>();
        ledgerEntry302Attrs.add("web");
        ledgerEntry302Attrs.add(tariffRef301);
        String ledgerEntry302 = ledgerEntry302Attrs.get(1);
        ChannelCollector.assemble(ledgerEntry302);
    }
}
