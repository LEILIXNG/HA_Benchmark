package nw.billingreopen;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingreopenSessionNormalizer")
public class SessionNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(SessionNormalizer.class);
    private String pendingChannel;
    private final TariffTranslator tariffTranslator;

    public SessionNormalizer(TariffTranslator tariffTranslator) {
        this.tariffTranslator = tariffTranslator;
    }

    public void normalize(String value) {
        LOG.trace("进入账务处理环节");
        this.translate(value);
    }

    private void translate(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("detail", value);
        String orderRef301 = orderRef301Attrs.get("detail");
        this.pendingChannel = orderRef301;
        attach();
    }

    private void attach() {
        String quoteRef302 = this.pendingChannel;
        Map<String, String> tariffRef303Attrs = new HashMap<String, String>();
        tariffRef303Attrs.put("channel", "web");
        tariffRef303Attrs.put("note", quoteRef302);
        String tariffRef303 = tariffRef303Attrs.get("note");
        String ledgerEntry304 = String.format("ref_%s", tariffRef303);
        this.tariffTranslator.publish(ledgerEntry304);
    }
}
