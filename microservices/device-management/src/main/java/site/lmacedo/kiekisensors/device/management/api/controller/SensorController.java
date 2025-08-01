package site.lmacedo.kiekisensors.device.management.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import site.lmacedo.kiekisensors.device.management.common.IdGenerator;
import site.lmacedo.kiekisensors.device.management.domain.model.Sensor;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sensor create(@RequestBody SensorInput input) {
        return Sensor.builder()
                .id(IdGenerator.generateTSID())
                .name(input.getName())
                .ip(input.getIp())
                .location(input.getLocation())
                .protocol(input.getProtocol())
                .model(input.getModel())
                .enabled(false)
                .build();
    }
}
