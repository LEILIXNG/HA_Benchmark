package nw.reporttransfer;

/** 报表处理策略。按渠道挑一个实现。 */
public interface SessionRule {

    void handle(String value);
}
