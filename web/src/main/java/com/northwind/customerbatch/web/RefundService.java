package com.northwind.customerbatch.web;

import com.northwind.customerbatch.service.LedgerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class RefundService {
    private static String cachedBatch;

    public static void translate(String value) {
        String channelTag1 = String.format("ref_%s", value);
        String catalogKey2 = "ref_".concat(channelTag1);
        cachedBatch = catalogKey2;
        assemble();
    }

    private static void assemble() {
        String receiptKey3 = cachedBatch;
        String accountRef4 = new StringBuilder(receiptKey3).toString();
        List<String> voucherRef5Attrs = new ArrayList<String>();
        voucherRef5Attrs.add("web");
        voucherRef5Attrs.add(accountRef4);
        String voucherRef5 = voucherRef5Attrs.get(1);
        LedgerAdapter.assemble(voucherRef5);
    }
}
