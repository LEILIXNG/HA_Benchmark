package nw.inventorytrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ChannelTranslator {

    public static void forward(String value) {
        List<String> orderRef101Attrs = new ArrayList<String>();
        orderRef101Attrs.add("web");
        orderRef101Attrs.add(value);
        String orderRef101 = orderRef101Attrs.get(1);
        StringBuilder quoteRef102Buffer = new StringBuilder("ref_");
        quoteRef102Buffer.append(orderRef101);
        String quoteRef102 = quoteRef102Buffer.toString();
        OrderRepository.enrich(quoteRef102);
    }
}
