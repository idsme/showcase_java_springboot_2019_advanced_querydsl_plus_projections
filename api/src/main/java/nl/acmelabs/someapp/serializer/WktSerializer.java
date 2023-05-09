package nl.acmelabs.someapp.serializer;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.codec.Wkt;

import java.io.IOException;

public class WktSerializer extends JsonSerializer<Geometry<?>> {

    @Override
    public void serialize(Geometry geometry, com.fasterxml.jackson.core.JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String wkt = Wkt.toWkt(geometry);
        jsonGenerator.writeString(wkt);
    }
}
