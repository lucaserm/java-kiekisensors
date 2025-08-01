package site.lmacedo.kiekisensors.temperature.monitoring.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorId;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.TemperatureLog;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.TemperatureLogId;

public interface TemperatureLogRepository extends JpaRepository<TemperatureLog, TemperatureLogId> {
    Page<TemperatureLog> findAllBySensorId(SensorId sensorId, Pageable pageable);
}
