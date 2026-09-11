package nw.paymenthold;

import nw.platform.ValidationException;
import org.springframework.stereotype.Repository;

/**
 * 支付明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("paymentholdShipmentPolicy")
public class ShipmentPolicy {
    private final PaymentRepository paymentRepository;

    public ShipmentPolicy(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void translate(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.replaceAll("'", "");
        this.paymentRepository.publish(cleaned);
    }
}
