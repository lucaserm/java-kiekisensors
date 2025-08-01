package site.lmacedo.kiekisensors.temperature.monitoring.api.controller;

import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import site.lmacedo.kiekisensors.temperature.monitoring.api.model.SensorAlertInput;
import site.lmacedo.kiekisensors.temperature.monitoring.api.model.SensorAlertOutput;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorAlert;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.model.SensorId;
import site.lmacedo.kiekisensors.temperature.monitoring.domain.repository.SensorAlertRepository;

@RestController
@RequestMapping("/api/sensors/{sensorId}/alert")
@RequiredArgsConstructor
public class SensorAlertController {
    private final SensorAlertRepository sensorAlertRepository;

    @GetMapping
    public SensorAlertOutput getDetail(@PathVariable TSID sensorId) {
        SensorAlert sensorAlert = findByIdOrThrow(sensorId);
        return convertToOutput(sensorAlert);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public SensorAlertOutput update(@PathVariable TSID sensorId, @RequestBody SensorAlertInput sensorAlertInput) {
        SensorAlert sensorAlert = findByIdOrDefault(sensorId);
        sensorAlert.setMaxTemperature(sensorAlertInput.getMaxTemperature());
        sensorAlert.setMinTemperature(sensorAlertInput.getMinTemperature());
        sensorAlert = sensorAlertRepository.saveAndFlush(sensorAlert);
        return convertToOutput(sensorAlert);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable TSID sensorId) {
        SensorAlert sensorAlert = findByIdOrThrow(sensorId);
        sensorAlertRepository.delete(sensorAlert);
    }

    private SensorAlert findByIdOrDefault(TSID sensorId) {
        return sensorAlertRepository.findById(new SensorId(sensorId))
                .orElse(SensorAlert.builder()
                        .id(new SensorId(sensorId))
                        .maxTemperature(null)
                        .minTemperature(null)
                        .build());
    }

    private SensorAlert findByIdOrThrow(TSID sensorId) {
        return sensorAlertRepository.findById(new SensorId(sensorId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private SensorAlertOutput convertToOutput(SensorAlert sensorAlert) {
        return SensorAlertOutput.builder()
                .id(sensorAlert.getId().getValue())
                .maxTemperature(sensorAlert.getMaxTemperature())
                .minTemperature(sensorAlert.getMinTemperature())
                .build();
    }
}
