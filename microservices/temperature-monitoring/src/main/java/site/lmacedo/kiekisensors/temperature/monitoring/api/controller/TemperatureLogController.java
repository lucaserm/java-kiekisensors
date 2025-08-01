package site.lmacedo.kiekisensors.temperature.monitoring.api.controller;

import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.lmacedo.kiekisensors.temperature.monitoring.api.model.TemperatureLogOutput;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorId;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.TemperatureLog;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.repository.TemperatureLogRepository;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures")
@RequiredArgsConstructor
public class TemperatureLogController {
    private final TemperatureLogRepository temperatureLogRepository;

    @GetMapping
    public PagedModel<TemperatureLogOutput> search(@PathVariable TSID sensorId, @PageableDefault Pageable pageable) {
        Page<TemperatureLog> temperatureLogs = temperatureLogRepository.findAllBySensorId(new SensorId(sensorId), pageable);
        return new PagedModel<>(temperatureLogs.map(log ->
                TemperatureLogOutput.builder()
                        .id(log.getId().getValue())
                        .sensorId(log.getSensorId().getValue())
                        .registeredAt(log.getRegisteredAt())
                        .value(log.getValue())
                        .build())
        );
    }
}
