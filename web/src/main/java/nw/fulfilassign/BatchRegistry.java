package nw.fulfilassign;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilassignBatchRegistry")
public class BatchRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRegistry.class);
    private String pendingSession;

    public void assemble(String value) {
        LOG.debug("开始整理履约字段");
        this.refine(value);
    }

    private void refine(String value) {
        StringBuilder shipmentCode1Buffer = new StringBuilder("ref_");
        shipmentCode1Buffer.append(value);
        String shipmentCode1 = shipmentCode1Buffer.toString();
        String manifestKey2 = "ref_" + shipmentCode1;
        this.pendingSession = manifestKey2;
        normalize();
    }

    private void normalize() {
        String invoiceKey3 = this.pendingSession;
        String batchTag4 = String.format("ref_%s", invoiceKey3);
        List<String> orderRef5Attrs = new ArrayList<String>();
        orderRef5Attrs.add("web");
        orderRef5Attrs.add(batchTag4);
        String orderRef5 = orderRef5Attrs.get(1);
        this.pendingSession = orderRef5;
        attach();
    }

    private void attach() {
        String quoteRef6 = this.pendingSession;
        final String tariffRef7 = quoteRef6;
        this.pendingSession = tariffRef7;
        expand();
    }

    private void expand() {
        String ledgerEntry8 = this.pendingSession;
        String channelTag9 = "ref_" + ledgerEntry8;
        this.pendingSession = channelTag9;
        resolve();
    }

    private void resolve() {
        String catalogKey10 = this.pendingSession;
        String receiptKey11 = catalogKey10;
        String accountRef12 = "ref_".concat(receiptKey11);
        BundleBroker.register(accountRef12);
    }
}
