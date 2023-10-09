package dev.satyam.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    //this is id column
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    //whose value should come from generator named uuidgenerator
//    @GeneratedValue(generator = "uuidgenerator")
//    // this is generator defined
//    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
//    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
//    private UUID uuid;
    private long id;
}
