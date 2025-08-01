package site.lmacedo.kiekisensors.temperature.monitoring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorAlert;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorId;

public interface SensorAlertRepository extends JpaRepository<SensorAlert, SensorId> {
}
