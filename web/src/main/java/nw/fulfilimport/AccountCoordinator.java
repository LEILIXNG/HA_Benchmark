package nw.fulfilimport;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilimportAccountCoordinator")
public class AccountCoordinator {
    private static String cachedCatalog;
    private final ChannelCoordinator channelCoordinator;

    public AccountCoordinator(ChannelCoordinator channelCoordinator) {
        this.channelCoordinator = channelCoordinator;
    }

    public void register(String value) {
        String channelTag201 = String.format("ref_%s", value);
        String catalogKey202 = "ref_".concat(channelTag201);
        cachedCatalog = catalogKey202;
        dispatch();
    }

    private void dispatch() {
        String receiptKey203 = cachedCatalog;
        StringBuilder accountRef204Buffer = new StringBuilder("ref_");
        accountRef204Buffer.append(receiptKey203);
        String accountRef204 = accountRef204Buffer.toString();
        Map<String, String> voucherRef205Attrs = new LinkedHashMap<String, String>();
        voucherRef205Attrs.put("channel", "web");
        voucherRef205Attrs.put("detail", accountRef204);
        String voucherRef205 = voucherRef205Attrs.getOrDefault("detail", "");
        this.channelCoordinator.forward(voucherRef205);
    }
}
