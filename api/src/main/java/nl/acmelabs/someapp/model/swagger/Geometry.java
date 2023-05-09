package nl.acmelabs.someapp.model.swagger;

import lombok.Data;

@Data
// Mock class to expose the JSON geometry structure via Swagger
public class Geometry {

    private String type;
    private Double[][] coordinates;
}
