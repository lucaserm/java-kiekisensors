package site.lmacedo.kiekisensors.device.management.api.client;

import io.hypersistence.tsid.TSID;
import site.lmacedo.kiekisensors.device.management.api.model.SensorMonitoringOutput;

public interface SensorMonitoringClient {
    void enableMonitoring(TSID sensorId);
    void disableMonitoring(TSID sensorId);
    SensorMonitoringOutput getDetail(TSID sensorId);
}
