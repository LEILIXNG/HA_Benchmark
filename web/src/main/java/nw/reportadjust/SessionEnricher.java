package nw.reportadjust;

import java.util.ArrayList;
import java.util.List;

/**
 * 报表受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class SessionEnricher {

    public static void dispatch(String value) {
        List<String> catalogKey201Attrs = new ArrayList<String>();
        catalogKey201Attrs.add("web");
        catalogKey201Attrs.add(value);
        String catalogKey201 = catalogKey201Attrs.get(1);
        LedgerCollector.route(catalogKey201);
    }
}
