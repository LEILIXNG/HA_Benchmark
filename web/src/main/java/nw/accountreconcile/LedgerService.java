package nw.accountreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountreconcileLedgerService")
public class LedgerService {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerService.class);
    private final SessionTranslator sessionTranslator;

    public LedgerService(SessionTranslator sessionTranslator) {
        this.sessionTranslator = sessionTranslator;
    }

    public void translate(String value) {
        LOG.debug("开始整理账户字段");
        String manifestKey201 = String.format("ref_%s", value);
        this.sessionTranslator.expand(manifestKey201);
    }
}
