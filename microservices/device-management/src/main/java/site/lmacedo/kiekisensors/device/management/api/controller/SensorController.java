package site.lmacedo.kiekisensors.device.management.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import site.lmacedo.kiekisensors.device.management.api.model.SensorInput;
import site.lmacedo.kiekisensors.device.management.api.model.SensorOutput;
import site.lmacedo.kiekisensors.device.management.common.IdGenerator;
import site.lmacedo.kiekisensors.device.management.domain.model.Sensor;
import site.lmacedo.kiekisensors.device.management.domain.model.SensorId;
import site.lmacedo.kiekisensors.device.management.domain.repository.SensorRepository;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorRepository sensorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SensorOutput create(@RequestBody SensorInput input) {
        Sensor sensor = Sensor.builder()
                .id(new SensorId(IdGenerator.generateTSID()))
                .name(input.getName())
                .ip(input.getIp())
                .location(input.getLocation())
                .protocol(input.getProtocol())
                .model(input.getModel())
                .enabled(false)
                .build();

        sensor = sensorRepository.saveAndFlush(sensor);

        return SensorOutput.builder()
                .id(sensor.getId().getValue())
                .name(sensor.getName())
                .ip(sensor.getIp())
                .location(sensor.getLocation())
                .protocol(sensor.getProtocol())
                .model(sensor.getModel())
                .enabled(sensor.getEnabled())
                .build();
    }
}
