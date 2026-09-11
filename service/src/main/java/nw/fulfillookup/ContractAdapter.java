package nw.fulfillookup;

import java.util.ArrayList;
import java.util.List;

/**
 * 履约明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ContractAdapter {

    public static void prepare(String value) {
        List<String> ledgerEntry201Attrs = new ArrayList<String>();
        ledgerEntry201Attrs.add("web");
        ledgerEntry201Attrs.add(value);
        String ledgerEntry201 = ledgerEntry201Attrs.get(1);
        String channelTag202 = ledgerEntry201;
        CatalogResolver.reconcile(channelTag202);
    }
}
