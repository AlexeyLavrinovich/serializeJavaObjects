package com.aliakseila.serializeJavaObjects.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "com.aliakseila.serializeJavaObjects.entity.CityTrade")
public class CityTrade extends Trade{
}
