package nw.vendorreview;

import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 供应商主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("vendorreviewCatalogEvaluator")
public class CatalogEvaluator {

    public void forward(String value) {
        String template = "'tag-' + '".concat(value).concat("'");
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
