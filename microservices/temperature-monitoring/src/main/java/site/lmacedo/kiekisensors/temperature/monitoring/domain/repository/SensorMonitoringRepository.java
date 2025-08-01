package site.lmacedo.kiekisensors.temperature.monitoring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorId;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorMonitoring;

public interface SensorMonitoringRepository extends JpaRepository<SensorMonitoring, SensorId> {
}
