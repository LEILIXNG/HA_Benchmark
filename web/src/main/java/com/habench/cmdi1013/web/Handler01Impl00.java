package com.habench.cmdi1013.web;

public final class Handler01Impl00 implements Handler01 {
    @Override
    public void handle(String value) {
        Stage01.apply(value);
    }
}
