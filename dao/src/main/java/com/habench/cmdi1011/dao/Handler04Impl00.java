package com.habench.cmdi1011.dao;

public final class Handler04Impl00 implements Handler04 {
    @Override
    public void handle(String value) {
        Stage04.apply(value);
    }
}
