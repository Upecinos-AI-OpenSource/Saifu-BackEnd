package com.upecinosai.saifu.platform.userInflation.interfaces.rest.transform;

import com.upecinosai.saifu.platform.userInflation.domain.model.UserInflation;
import com.upecinosai.saifu.platform.userInflation.domain.model.UserInflationId;
import com.upecinosai.saifu.platform.userInflation.interfaces.rest.resources.UserInflationResource;
import org.springframework.stereotype.Component;

@Component
public class UserInflationCommandFromResourceAssembler {

    public UserInflation toEntity(UserInflationResource resource) {
        UserInflation userInflation = new UserInflation();
        userInflation.setId(new UserInflationId(resource.getUserId(), resource.getReportId()));
        return userInflation;
    }
}
