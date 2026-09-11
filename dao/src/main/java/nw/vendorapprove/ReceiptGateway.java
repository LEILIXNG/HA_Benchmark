package nw.vendorapprove;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("vendorapproveReceiptGateway")
public class ReceiptGateway {

    public void reconcile(String value) {
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            this.resolve(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void resolve(ReceiptMapper mapper, String value) {
        mapper.reconcile(value);
    }
}
