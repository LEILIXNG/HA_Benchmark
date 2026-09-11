package nw.reportverify;

/** 报表处理策略。按渠道挑一个实现。 */
public interface BundlePolicy {

    void handle(String value);
}
