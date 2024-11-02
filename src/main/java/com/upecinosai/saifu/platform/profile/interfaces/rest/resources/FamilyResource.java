package com.upecinosai.saifu.platform.profile.interfaces.rest.resources;

import com.upecinosai.saifu.platform.profile.domain.model.valueObjects.PhoneNumber;

public record FamilyResource(Long familyId, Long userId, String familyName, int members, String direction, PhoneNumber phoneNumber) {
}
