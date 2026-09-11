package nw.fulfilnotice;

import java.util.ArrayList;
import java.util.List;

/**
 * 履约主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BundleAdapter {

    public static void prepare(String value) {
        List<String> ledgerEntry101Attrs = new ArrayList<String>();
        ledgerEntry101Attrs.add("web");
        ledgerEntry101Attrs.add(value);
        String ledgerEntry101 = ledgerEntry101Attrs.get(1);
        String channelTag102 = "ref_" + ledgerEntry101;
        InvoiceRegistry.expand(channelTag102);
    }
}
