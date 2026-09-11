package nw.reportposting;

/** 报表处理策略。按渠道挑一个实现。 */
public interface CatalogRule {

    void handle(String value);
}
