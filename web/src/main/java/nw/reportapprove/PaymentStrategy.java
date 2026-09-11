package nw.reportapprove;

/** 报表处理策略。按渠道挑一个实现。 */
public interface PaymentStrategy {

    void handle(String value);
}
