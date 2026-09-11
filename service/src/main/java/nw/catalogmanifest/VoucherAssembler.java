package nw.catalogmanifest;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogmanifestVoucherAssembler")
public class VoucherAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAssembler.class);
    private final BatchValidator batchValidator;

    public VoucherAssembler(BatchValidator batchValidator) {
        this.batchValidator = batchValidator;
    }

    public void normalize(String value) {
        LOG.debug("商品流程转下一环节");
        String invoiceKey201 = String.valueOf(value);
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("remark", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("remark");
        this.batchValidator.expand(batchTag202);
    }
}
