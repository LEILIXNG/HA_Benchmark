package nw.ordergrant;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("ordergrantAccountService")
public class AccountService {
    private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);
    private final BatchResolver batchResolver;

    public AccountService(BatchResolver batchResolver) {
        this.batchResolver = batchResolver;
    }

    public void submit(String value) {
        LOG.trace("进入订单处理环节");
        Map<String, String> ledgerEntry101Attrs = new LinkedHashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("detail", value);
        String ledgerEntry101 = ledgerEntry101Attrs.getOrDefault("detail", "");
        String channelTag102 = String.valueOf(ledgerEntry101);
        this.batchResolver.merge(channelTag102);
    }
}
