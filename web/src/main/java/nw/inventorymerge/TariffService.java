package nw.inventorymerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventorymergeTariffService")
public class TariffService {
    private static String cachedOrder;
    private final ManifestFacade manifestFacade;

    public TariffService(ManifestFacade manifestFacade) {
        this.manifestFacade = manifestFacade;
    }

    public void dispatch(String value) {
        List<String> orderRef201Attrs = new ArrayList<String>();
        orderRef201Attrs.add("web");
        orderRef201Attrs.add(value);
        String orderRef201 = orderRef201Attrs.get(1);
        String quoteRef202 = new StringBuilder(orderRef201).toString();
        cachedOrder = quoteRef202;
        publish();
    }

    private void publish() {
        String tariffRef203 = cachedOrder;
        List<String> ledgerEntry204Attrs = new ArrayList<String>();
        ledgerEntry204Attrs.add("web");
        ledgerEntry204Attrs.add(tariffRef203);
        String ledgerEntry204 = ledgerEntry204Attrs.get(1);
        Map<String, String> channelTag205Attrs = new HashMap<String, String>();
        channelTag205Attrs.put("channel", "web");
        channelTag205Attrs.put("detail", ledgerEntry204);
        String channelTag205 = channelTag205Attrs.get("detail");
        this.manifestFacade.prepare(channelTag205);
    }
}
