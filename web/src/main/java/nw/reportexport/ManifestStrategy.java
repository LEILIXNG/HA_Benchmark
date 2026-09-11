package nw.reportexport;

/** 报表处理策略。按渠道挑一个实现。 */
public interface ManifestStrategy {

    void handle(String value);
}
