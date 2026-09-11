package nw.accountsync;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;

/**
 * 面向账户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class RefundFetcher {

    public static void refine(String value) {
        String endpointUrl = "http://" + value + "/status";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
