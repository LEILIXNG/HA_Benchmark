package nw.catalogposting;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogpostingReceiptRouter")
public class ReceiptRouter {
    private final AccountLoader accountLoader;

    public ReceiptRouter(AccountLoader accountLoader) {
        this.accountLoader = accountLoader;
    }

    public void prepare(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("detail", value);
        String quoteRef201 = quoteRef201Attrs.get("detail");
        this.accountLoader.route(quoteRef201);
    }
}
