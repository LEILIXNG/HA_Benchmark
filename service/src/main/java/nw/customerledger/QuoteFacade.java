package nw.customerledger;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteFacade {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteFacade.class);
    private static String cachedShipment;

    public static void dispatch(String value) {
        LOG.debug("客户流程转下一环节");
        List<String> orderRef201Attrs = new ArrayList<String>();
        orderRef201Attrs.add("web");
        orderRef201Attrs.add(value);
        String orderRef201 = orderRef201Attrs.get(1);
        String quoteRef202 = "ref_".concat(orderRef201);
        cachedShipment = quoteRef202;
        merge();
    }

    private static void merge() {
        String tariffRef203 = cachedShipment;
        StringBuilder ledgerEntry204Buffer = new StringBuilder("ref_");
        ledgerEntry204Buffer.append(tariffRef203);
        String ledgerEntry204 = ledgerEntry204Buffer.toString();
        ContractAssembler.prepare(ledgerEntry204);
    }
}
