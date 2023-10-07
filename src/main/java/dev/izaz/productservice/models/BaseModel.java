package dev.izaz.productservice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
	@Id
	//@GeneratedValue(generator = "uuidgenerator")//strategy = "uuid2"
	@GeneratedValue(strategy = GenerationType.UUID)
	//@GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
	//@Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
	@Column(name = "id", nullable = false, updatable = false)
	private UUID uuid;
}
