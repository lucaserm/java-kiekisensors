package site.lmacedo.kiekisensors.temperature.monitoring.api.model;

import lombok.Builder;
import lombok.Data;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorId;

import java.time.OffsetDateTime;

@Data
@Builder
public class SensorMonitoringOutput {
    private SensorId id;
    private Double lastTemperature;
    private OffsetDateTime updatedAt;
    private Boolean enabled;
}
