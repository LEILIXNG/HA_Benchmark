package nw.inventorysettle;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventorysettleTariffCoordinator")
public class TariffCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(TariffCoordinator.class);
    private final InvoiceAssembler invoiceAssembler;

    public TariffCoordinator(InvoiceAssembler invoiceAssembler) {
        this.invoiceAssembler = invoiceAssembler;
    }

    public void register(String value) {
        LOG.debug("库存流程转下一环节");
        String tariffRef1 = String.format("ref_%s", value);
        Map<String, String> ledgerEntry2Attrs = new LinkedHashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("remark", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.getOrDefault("remark", "");
        this.invoiceAssembler.publish(ledgerEntry2);
    }
}
