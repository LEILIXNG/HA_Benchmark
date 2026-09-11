package nw.customergrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class QuoteAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteAssembler.class);

    public static void assemble(String value) {
        LOG.debug("接收到一次客户处理请求");
        String manifestKey101 = new StringBuilder(value).toString();
        SessionBroker.submit(manifestKey101);
    }
}
