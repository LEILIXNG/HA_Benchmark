package nw.catalogtransfer;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherCollector {

    public static void expand(String value) {
        List<String> tariffRef201Attrs = new ArrayList<String>();
        tariffRef201Attrs.add("web");
        tariffRef201Attrs.add(value);
        String tariffRef201 = tariffRef201Attrs.get(1);
        String ledgerEntry202 = "ref_".concat(tariffRef201);
        RefundFetcher.expand(ledgerEntry202);
    }
}
