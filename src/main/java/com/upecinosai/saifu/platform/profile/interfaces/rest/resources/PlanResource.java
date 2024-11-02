package com.upecinosai.saifu.platform.profile.interfaces.rest.resources;

import java.math.BigDecimal;

public record PlanResource(Long planId, String planName, String description, BigDecimal cost, int monthDuration, Long userId) {
}
