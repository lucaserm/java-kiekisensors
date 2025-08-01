package site.lmacedo.kiekisensors.temperature.processing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import site.lmacedo.kiekisensors.temperature.processing.common.IdGenerator;
import site.lmacedo.kiekisensors.temperature.processing.common.UUIDv7Utils;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

class UUIDv7Test {

    @Test
    void shouldGenerateUUIDv7(){
        UUID uuid = IdGenerator.generateTimeBasedUUID();
        OffsetDateTime uuidDateTime = UUIDv7Utils.extractOffsetDateTime(uuid).truncatedTo(ChronoUnit.MINUTES);
        OffsetDateTime currentDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        Assertions.assertThat(uuidDateTime).isEqualTo(currentDateTime);
    }
}
