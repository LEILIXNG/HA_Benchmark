package nw.reportnotice;

/** 报表处理策略。按渠道挑一个实现。 */
public interface PaymentPolicy {

    void handle(String value);
}
