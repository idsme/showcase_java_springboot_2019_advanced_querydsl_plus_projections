package nl.acmelabs.someapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reference implements IReference, IId {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "referenceSequenceGenerator")
    @SequenceGenerator(name="referenceSequenceGenerator", sequenceName = "REF_SEQ", allocationSize = 1)
    private Long id;

    @Column
    private String type;

    @Column
    private String name;

    @Column(length = 4000)
    private String description;

    private Long sequenceNumber;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Date created;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date modified;

    @Override
    public String getReferenceId() {
        return "/" + this.id;
    }

}
