package com.northwind.billinggrant.service;

import org.springframework.stereotype.Service;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("billinggrantReceiptService")
public class ReceiptService {
    private final BatchGuard batchGuard;

    public ReceiptService(BatchGuard batchGuard) {
        this.batchGuard = batchGuard;
    }

    public void expand(String value) {
        String tariffRef101 = String.valueOf(value);
        this.batchGuard.translate(tariffRef101);
    }
}
