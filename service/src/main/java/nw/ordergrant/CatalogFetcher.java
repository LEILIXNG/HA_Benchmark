package nw.ordergrant;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向订单场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class CatalogFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogFetcher.class);
    private static final Set<String> ALLOWED_HOSTS =
            new HashSet<String>(Arrays.asList("api.internal.example",
                    "cdn.example"));

    public static void collect(String value) {
        LOG.debug("接收到一次订单处理请求");
        String endpointUrl = String.format("http://%s/status", value);
        try {
            URL endpoint = new URL(endpointUrl);
            if (!ALLOWED_HOSTS.contains(endpoint.getHost())) {
                throw new IllegalArgumentException("host not allowed");
            }
            AuditTrail.emit("http", endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
