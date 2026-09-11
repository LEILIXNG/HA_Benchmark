package nw.fulfildigest;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("fulfildigestReceiptGateway")
public class ReceiptGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptGateway.class);

    public void refine(String value) {
        LOG.debug("接收到一次履约处理请求");
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            this.prepare(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void prepare(ReceiptMapper mapper, String value) {
        mapper.resolve(value);
    }
}
