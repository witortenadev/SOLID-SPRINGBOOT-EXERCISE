package com.witortena.solid.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public abstract class Product {
    private final String name;
    private final BigDecimal price;

    public abstract String getType();

    public abstract String getDescription();
}
