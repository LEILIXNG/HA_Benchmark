package nw.fulfilmerge;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("fulfilmergeReceiptBuilder")
public class ReceiptBuilder {
    private static String cachedInvoice;
    private final TariffFacade tariffFacade;

    public ReceiptBuilder(TariffFacade tariffFacade) {
        this.tariffFacade = tariffFacade;
    }

    public void resolve(String value) {
        StringBuilder quoteRef1Buffer = new StringBuilder("ref_");
        quoteRef1Buffer.append(value);
        String quoteRef1 = quoteRef1Buffer.toString();
        cachedInvoice = quoteRef1;
        register();
    }

    private void register() {
        String tariffRef2 = cachedInvoice;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("note", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("note");
        String channelTag4 = String.format("ref_%s", ledgerEntry3);
        this.tariffFacade.dispatch(channelTag4);
    }
}
