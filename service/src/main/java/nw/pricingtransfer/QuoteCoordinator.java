package nw.pricingtransfer;

import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("pricingtransferQuoteCoordinator")
public class QuoteCoordinator {

    public void assemble(String value) {
        String catalogKey201 = "ref_" + value;
        OrderValidator.submit(catalogKey201);
    }
}
