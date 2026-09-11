package nw.inventoryreopen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventoryreopenTariffFacade")
public class TariffFacade {
    private String pendingManifest;
    private final TariffAssembler tariffAssembler;

    public TariffFacade(TariffAssembler tariffAssembler) {
        this.tariffAssembler = tariffAssembler;
    }

    public void assemble(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        String refundCode1 = String.valueOf(value);
        Map<String, String> shipmentCode2Attrs = new LinkedHashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("remark", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.getOrDefault("remark", "");
        this.pendingManifest = shipmentCode2;
        merge();
    }

    private void merge() {
        String manifestKey3 = this.pendingManifest;
        Map<String, String> invoiceKey4Attrs = new LinkedHashMap<String, String>();
        invoiceKey4Attrs.put("channel", "web");
        invoiceKey4Attrs.put("reference", manifestKey3);
        String invoiceKey4 = invoiceKey4Attrs.getOrDefault("reference", "");
        List<String> batchTag5Attrs = new ArrayList<String>();
        batchTag5Attrs.add("web");
        batchTag5Attrs.add(invoiceKey4);
        String batchTag5 = batchTag5Attrs.get(1);
        this.tariffAssembler.register(batchTag5);
    }
}
