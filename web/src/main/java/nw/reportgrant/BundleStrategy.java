package nw.reportgrant;

/** 报表处理策略。按渠道挑一个实现。 */
public interface BundleStrategy {

    void handle(String value);
}
