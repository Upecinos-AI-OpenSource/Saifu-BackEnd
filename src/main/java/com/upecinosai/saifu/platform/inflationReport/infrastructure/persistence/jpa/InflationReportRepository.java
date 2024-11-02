package com.upecinosai.saifu.platform.inflationReport.infrastructure.persistence.jpa;

import com.upecinosai.saifu.platform.inflationReport.domain.model.InflationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InflationReportRepository extends JpaRepository<InflationReport, Long> {
}
