package site.lmacedo.kiekisensors.device.management.api.client;

import io.hypersistence.tsid.TSID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import site.lmacedo.kiekisensors.device.management.api.model.SensorMonitoringOutput;

@HttpExchange("/api/sensors/{sensorId}/monitoring")
public interface SensorMonitoringClient {
    @PutMapping("/enable")
    void enableMonitoring(@PathVariable TSID sensorId);

    @DeleteExchange("/enable")
    void disableMonitoring(@PathVariable TSID sensorId);

    @GetExchange
    SensorMonitoringOutput getDetail(@PathVariable TSID sensorId);
}
