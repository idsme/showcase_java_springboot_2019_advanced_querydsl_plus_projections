package nl.acmelabs.someapp.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.codec.Wkt;

import java.io.IOException;

public class WktDeserializer extends JsonDeserializer<Geometry<?>> {

    @Override
    public Geometry<?> deserialize(com.fasterxml.jackson.core.JsonParser jsonParser, com.fasterxml.jackson.databind.DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getValueAsString();
        return Wkt.fromWkt(value);
    }
}