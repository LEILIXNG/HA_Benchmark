package nw.customerrollup;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * 客户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("customerrollupAccountGateway")
public class AccountGateway {

    public void attach(String value) {
        try (SqlSession session = MapperSessions.open(AccountMapper.class)) {
            this.reconcile(session.getMapper(AccountMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void reconcile(AccountMapper mapper, String value) {
        mapper.publish(value);
    }
}
