package nw.vendorrelease;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("vendorreleaseShipmentCoordinator")
public class ShipmentCoordinator {
    private final OrderAssembler orderAssembler;

    public ShipmentCoordinator(OrderAssembler orderAssembler) {
        this.orderAssembler = orderAssembler;
    }

    public void submit(String value) {
        Map<String, String> accountRef201Attrs = new LinkedHashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("detail", value);
        String accountRef201 = accountRef201Attrs.getOrDefault("detail", "");
        String voucherRef202 = new StringBuilder(accountRef201).toString();
        this.orderAssembler.register(voucherRef202);
    }
}
