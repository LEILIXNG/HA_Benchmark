package nw.orderrefund;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("orderrefundBundleBroker")
public class BundleBroker {
    private static final Logger LOG = LoggerFactory.getLogger(BundleBroker.class);
    private final BundleFacade bundleFacade;

    public BundleBroker(BundleFacade bundleFacade) {
        this.bundleFacade = bundleFacade;
    }

    public void dispatch(String value) {
        LOG.debug("订单流程转下一环节");
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("detail", value);
        String tariffRef101 = tariffRef101Attrs.get("detail");
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("remark", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("remark");
        this.bundleFacade.forward(ledgerEntry102);
    }
}
