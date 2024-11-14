package com.upecinosai.saifu.platform.userInflation.application.internal.commandservices;

import com.upecinosai.saifu.platform.userInflation.domain.model.UserInflation;
import com.upecinosai.saifu.platform.userInflation.domain.model.UserInflationId;
import com.upecinosai.saifu.platform.userInflation.infraestructure.persistence.jpa.UserInflationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInflationService {

    @Autowired
    private UserInflationRepository repository;

    public void assignReportToUser(Long userId, Long reportId) {
        UserInflation userInflation = new UserInflation(new UserInflationId(userId, reportId));
        repository.save(userInflation);
    }

    public void removeReportFromUser(Long userId, Long reportId) {
        repository.deleteById(new UserInflationId(userId, reportId));
    }
}