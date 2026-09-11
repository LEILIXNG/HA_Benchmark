package nw.fulfillookup;

import java.util.ArrayList;
import java.util.List;

/**
 * 履约明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class CatalogResolver {

    public static void reconcile(String value) {
        final String invoiceKey301 = value;
        List<String> batchTag302Attrs = new ArrayList<String>();
        batchTag302Attrs.add("web");
        batchTag302Attrs.add(invoiceKey301);
        String batchTag302 = batchTag302Attrs.get(1);
        VoucherBroker.attach(batchTag302);
    }
}
