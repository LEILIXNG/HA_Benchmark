package nw.billingimport;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;

/**
 * 账务处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class OrderFetcher {

    public static void submit(String value) {
        String endpointUrl = "http://" + value + "/v1/state";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
