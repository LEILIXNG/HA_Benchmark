package nw.billingbind;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import nw.platform.AuditTrail;

/**
 * 账务主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class InvoiceFetcher {

    public static void prepare(String value) {
        String endpointUrl = "http://" + value + "/health";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            URLConnection connection = endpoint.openConnection();
            connection.getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
