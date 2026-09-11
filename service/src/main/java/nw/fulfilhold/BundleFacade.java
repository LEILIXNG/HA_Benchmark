package nw.fulfilhold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfilholdBundleFacade")
public class BundleFacade {
    private static final Logger LOG = LoggerFactory.getLogger(BundleFacade.class);

    public void refine(String value) {
        LOG.trace("进入履约处理环节");
        String receiptKey201 = "ref_" + value;
        final String accountRef202 = receiptKey201;
        BundleAssembler.refine(accountRef202);
    }
}
