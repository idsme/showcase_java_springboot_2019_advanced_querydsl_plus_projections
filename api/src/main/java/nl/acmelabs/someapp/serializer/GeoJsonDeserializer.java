package nl.acmelabs.someapp.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.LineString;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.geolatte.geom.json.GeometryDeserializer;

import java.io.IOException;

public class GeoJsonDeserializer extends JsonDeserializer<Geometry<?>> {
    private GeometryDeserializer deserializer;

    public GeoJsonDeserializer() {
        deserializer = (GeometryDeserializer) new GeolatteGeomModule().getGeometryDeserializers().get(LineString.class);
    }

    @Override
    public Geometry<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return deserializer.deserialize(jsonParser, deserializationContext);
    }
}