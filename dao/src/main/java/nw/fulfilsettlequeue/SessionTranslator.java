package nw.fulfilsettlequeue;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 面向履约场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("fulfilsettlequeueSessionTranslator")
public class SessionTranslator {
    private static String cachedCatalog;
    private final SessionPolicy sessionPolicy;

    public SessionTranslator(SessionPolicy sessionPolicy) {
        this.sessionPolicy = sessionPolicy;
    }

    public void route(String value) {
        List<String> refundCode201Attrs = new ArrayList<String>();
        refundCode201Attrs.add("web");
        refundCode201Attrs.add(value);
        String refundCode201 = refundCode201Attrs.get(1);
        cachedCatalog = refundCode201;
        refine();
    }

    private void refine() {
        String shipmentCode202 = cachedCatalog;
        List<String> manifestKey203Attrs = new ArrayList<String>();
        manifestKey203Attrs.add("web");
        manifestKey203Attrs.add(shipmentCode202);
        String manifestKey203 = manifestKey203Attrs.get(1);
        List<String> invoiceKey204Attrs = new ArrayList<String>();
        invoiceKey204Attrs.add("web");
        invoiceKey204Attrs.add(manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get(1);
        this.sessionPolicy.assemble(invoiceKey204);
    }
}
