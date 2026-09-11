package nw.reportquote;

/** 报表处理策略。按渠道挑一个实现。 */
public interface OrderStrategy {

    void handle(String value);
}
