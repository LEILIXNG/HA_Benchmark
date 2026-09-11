package nw.billingadjust;

/** 账务处理策略。按渠道挑一个实现。 */
public interface InvoicePlan {

    void handle(String value);
}
