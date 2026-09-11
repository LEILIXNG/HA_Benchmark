package nw.catalogquote;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向商品场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("catalogquoteVoucherAssembler")
public class VoucherAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAssembler.class);
    private final CatalogAssembler catalogAssembler;

    public VoucherAssembler(CatalogAssembler catalogAssembler) {
        this.catalogAssembler = catalogAssembler;
    }

    public void expand(String value) {
        LOG.debug("开始整理商品字段");
        Map<String, String> tariffRef101Attrs = new LinkedHashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("detail", value);
        String tariffRef101 = tariffRef101Attrs.getOrDefault("detail", "");
        Map<String, String> ledgerEntry102Attrs = new LinkedHashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("remark", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.getOrDefault("remark", "");
        this.catalogAssembler.compose(ledgerEntry102);
    }
}
