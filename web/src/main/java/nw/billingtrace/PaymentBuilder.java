package nw.billingtrace;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 账务明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentBuilder {
    private static String cachedBundle;

    public static void compose(String value) {
        List<String> ledgerEntry1Attrs = new ArrayList<String>();
        ledgerEntry1Attrs.add("web");
        ledgerEntry1Attrs.add(value);
        String ledgerEntry1 = ledgerEntry1Attrs.get(1);
        Map<String, String> channelTag2Attrs = new LinkedHashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("remark", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.getOrDefault("remark", "");
        cachedBundle = channelTag2;
        attach();
    }

    private static void attach() {
        String catalogKey3 = cachedBundle;
        StringBuilder receiptKey4Buffer = new StringBuilder("ref_");
        receiptKey4Buffer.append(catalogKey3);
        String receiptKey4 = receiptKey4Buffer.toString();
        PaymentFacade.collect(receiptKey4);
    }
}
