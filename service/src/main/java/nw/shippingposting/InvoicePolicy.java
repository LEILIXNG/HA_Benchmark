package nw.shippingposting;

/** 发运处理策略。按渠道挑一个实现。 */
public interface InvoicePolicy {

    void handle(String value);
}
