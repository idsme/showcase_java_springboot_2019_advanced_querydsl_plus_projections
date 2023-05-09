package nl.acmelabs.someapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequenceGenerator")
    @SequenceGenerator(name = "userSequenceGenerator", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ref_operator")
    private Reference operatorRef;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column
    private Date modified;

    @Column(length = 4000)
    public String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = false)
    @Fetch(value = FetchMode.SUBSELECT)
    public List<Project> projects;

    public User(Long id) {
        this.id = id;
    }
}
