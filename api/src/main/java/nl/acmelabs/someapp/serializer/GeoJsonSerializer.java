package nl.acmelabs.someapp.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.geolatte.geom.json.GeometrySerializer;

import java.io.IOException;

public class GeoJsonSerializer extends JsonSerializer<Geometry<?>> {

    private GeometrySerializer serializer;

    public GeoJsonSerializer() {
        serializer = new GeolatteGeomModule().getGeometrySerializer();
    }

    @Override
    public void serialize(Geometry<?> geometry, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializer.serialize(geometry, jsonGenerator, serializerProvider);
    }

}
