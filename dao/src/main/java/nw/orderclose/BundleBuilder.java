package nw.orderclose;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 订单受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("ordercloseBundleBuilder")
public class BundleBuilder {
    private String pendingManifest;

    public void refine(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        List<String> tariffRef201Attrs = new ArrayList<String>();
        tariffRef201Attrs.add("web");
        tariffRef201Attrs.add(value);
        String tariffRef201 = tariffRef201Attrs.get(1);
        List<String> ledgerEntry202Attrs = new ArrayList<String>();
        ledgerEntry202Attrs.add("web");
        ledgerEntry202Attrs.add(tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.get(1);
        this.pendingManifest = ledgerEntry202;
        translate();
    }

    private void translate() {
        String channelTag203 = this.pendingManifest;
        String catalogKey204 = new StringBuilder(channelTag203).toString();
        final String receiptKey205 = catalogKey204;
        ManifestRepository.normalize(receiptKey205);
    }
}
