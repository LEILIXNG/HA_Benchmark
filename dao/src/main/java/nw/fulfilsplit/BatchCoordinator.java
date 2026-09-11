package nw.fulfilsplit;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("fulfilsplitBatchCoordinator")
public class BatchCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchCoordinator.class);

    public void register(String value) {
        LOG.trace("进入履约处理环节");
        List<String> manifestKey401Attrs = new ArrayList<String>();
        manifestKey401Attrs.add("web");
        manifestKey401Attrs.add(value);
        String manifestKey401 = manifestKey401Attrs.get(1);
        List<String> invoiceKey402Attrs = new ArrayList<String>();
        invoiceKey402Attrs.add("web");
        invoiceKey402Attrs.add(manifestKey401);
        String invoiceKey402 = invoiceKey402Attrs.get(1);
        BatchFetcher.prepare(invoiceKey402);
    }
}
