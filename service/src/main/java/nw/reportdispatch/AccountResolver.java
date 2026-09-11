package nw.reportdispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class AccountResolver {
    private static final Logger LOG = LoggerFactory.getLogger(AccountResolver.class);

    public static void forward(String value) {
        LOG.trace("进入报表处理环节");
        final String shipmentCode101 = value;
        String manifestKey102 = new StringBuilder(shipmentCode101).toString();
        ContractNormalizer.enrich(manifestKey102);
    }
}
