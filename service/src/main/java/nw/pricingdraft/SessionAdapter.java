package nw.pricingdraft;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("pricingdraftSessionAdapter")
public class SessionAdapter {

    public void dispatch(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("detail", value);
        String accountRef201 = accountRef201Attrs.get("detail");
        ChannelGateway.translate(accountRef201);
    }
}
