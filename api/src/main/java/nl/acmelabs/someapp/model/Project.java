package nl.acmelabs.someapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.acmelabs.someapp.projections.PProject;
import nl.acmelabs.someapp.serializer.GeoJsonDeserializer;
import nl.acmelabs.someapp.serializer.GeoJsonSerializer;
import nl.acmelabs.someapp.serializer.WktDeserializer;
import nl.acmelabs.someapp.serializer.WktSerializer;
import org.geolatte.geom.Geometry;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table
public class Project implements PProject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSequenceGenerator")
    @SequenceGenerator(name = "projectSequenceGenerator", sequenceName = "PROJECT_SEQ", allocationSize = 1)
    @Column
    public Long id;

    @Column
    private String name;

    @Column
    private Double length;

    @Column(length = 4000)
    @JsonSerialize(using = WktSerializer.class)
    @JsonDeserialize(using = WktDeserializer.class)
    @ApiModelProperty(dataType = "swagger.model.nl.acmelabs.Geometry")
    private Geometry<?> geometry;

    @SuppressWarnings("squid:S1452") //Temp. disabled warning when usage of generic wildcard type.
    @JsonProperty("geometryAsGeoJson")
    @JsonSerialize(using = GeoJsonSerializer.class)
    public Geometry<?> getGeometryAsGeoJson() {
        return geometry;
    }

    @SuppressWarnings("squid:S1452") //Temp. disabled warning when usage of generic wildcard type.
    @JsonProperty("geometryAsGeoJson")
    @JsonDeserialize(using = GeoJsonDeserializer.class)
    public void setGeometryAsGeoJson(Geometry<?> geometry) {
        this.geometry = geometry;
    }

    @Column(updatable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private final Boolean deleted = false;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date acquisitionEndDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_ref_environment")
    private Reference environmentRef;

    @Column(length = 4000)
    private String description;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column
    private Date modified;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_user")
    public User user;

    @JsonIgnore
    public Long getUserId() {
        log.info("Getting>>userId>>" + id + " Current Object:>" + toString());
        return user == null ? null : user.getId();
    }

    // Tested this works using direct Spring Data Rest Endpoint
    @JsonIgnore
    public void setUserId(Long id) {
        log.info("Setting>>userId>>" + id + " Current Object:>" + toString());
        this.user = new User(id);
        log.info("Current Object:>" + toString());
    }

    public Project(Long id) {
        this.id = id;
    }
}
