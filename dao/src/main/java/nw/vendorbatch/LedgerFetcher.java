package nw.vendorbatch;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;

/**
 * 供应商受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class LedgerFetcher {

    public static void submit(String value) {
        StringBuilder endpointUrlBuffer = new StringBuilder("http://");
        endpointUrlBuffer.append(value).append("/status");
        String endpointUrl = endpointUrlBuffer.toString();
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
