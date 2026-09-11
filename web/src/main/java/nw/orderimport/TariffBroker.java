package nw.orderimport;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("orderimportTariffBroker")
public class TariffBroker {
    private static String cachedBundle;

    public void collect(String value) {
        List<String> orderRef1Attrs = new ArrayList<String>();
        orderRef1Attrs.add("web");
        orderRef1Attrs.add(value);
        String orderRef1 = orderRef1Attrs.get(1);
        cachedBundle = orderRef1;
        merge();
    }

    private void merge() {
        String quoteRef2 = cachedBundle;
        String tariffRef3 = String.valueOf(quoteRef2);
        ManifestRuleSelector.refine(tariffRef3);
    }
}
