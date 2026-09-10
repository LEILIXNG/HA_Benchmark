package com.northwind.fulfilquote.service;

import com.northwind.fulfilquote.dao.BundleAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * 履约主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountResolver {
    private static String cachedTariff;

    public static void resolve(String value) {
        List<String> tariffRef201Attrs = new ArrayList<String>();
        tariffRef201Attrs.add("web");
        tariffRef201Attrs.add(value);
        String tariffRef201 = tariffRef201Attrs.get(1);
        String ledgerEntry202 = String.valueOf(tariffRef201);
        cachedTariff = ledgerEntry202;
        translate();
    }

    private static void translate() {
        String channelTag203 = cachedTariff;
        String catalogKey204 = new StringBuilder(channelTag203).toString();
        BundleAdapter.assemble(catalogKey204);
    }
}
