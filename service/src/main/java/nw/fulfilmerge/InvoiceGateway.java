package nw.fulfilmerge;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("fulfilmergeInvoiceGateway")
public class InvoiceGateway {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceGateway.class);

    public void reconcile(String value) {
        LOG.debug("履约流程转下一环节");
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            this.prepare(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void prepare(InvoiceMapper mapper, String value) {
        mapper.merge(value);
    }
}
