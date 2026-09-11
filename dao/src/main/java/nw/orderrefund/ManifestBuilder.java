package nw.orderrefund;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("orderrefundManifestBuilder")
public class ManifestBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestBuilder.class);
    private final BatchFilter batchFilter;

    public ManifestBuilder(BatchFilter batchFilter) {
        this.batchFilter = batchFilter;
    }

    public void translate(String value) {
        LOG.debug("订单流程转下一环节");
        List<String> tariffRef401Attrs = new ArrayList<String>();
        tariffRef401Attrs.add("web");
        tariffRef401Attrs.add(value);
        String tariffRef401 = tariffRef401Attrs.get(1);
        String ledgerEntry402 = new StringBuilder(tariffRef401).toString();
        this.batchFilter.assemble(ledgerEntry402);
    }
}
