package nw.vendormerge;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("vendormergeCatalogGateway")
public class CatalogGateway {

    public void stage(String value) {
        try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
            this.forward(session.getMapper(CatalogMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void forward(CatalogMapper mapper, String value) {
        mapper.translate(value);
    }
}
