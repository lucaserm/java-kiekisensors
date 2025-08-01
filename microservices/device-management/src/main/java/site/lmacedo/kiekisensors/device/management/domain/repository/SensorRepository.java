package site.lmacedo.kiekisensors.device.management.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.lmacedo.kiekisensors.device.management.domain.model.Sensor;
import site.lmacedo.kiekisensors.device.management.domain.model.SensorId;

public interface SensorRepository extends JpaRepository<Sensor, SensorId> {
}
