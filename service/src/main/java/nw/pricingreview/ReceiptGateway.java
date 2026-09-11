package nw.pricingreview;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingreviewReceiptGateway")
public class ReceiptGateway {

    public void refine(String value) {
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            this.forward(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void forward(ReceiptMapper mapper, String value) {
        mapper.resolve(value);
    }
}
