package com.aliakseila.serializeJavaObjects.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "com.aliakseila.serializeJavaObjects.entity.ZkbTrade")
public class ZkbTrade extends Trade{
}
