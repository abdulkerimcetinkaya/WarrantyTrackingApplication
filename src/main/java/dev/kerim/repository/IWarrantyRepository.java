package dev.kerim.repository;

import dev.kerim.entities.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource(excerptProjection = WarrantyProjection.class)
public interface IWarrantyRepository extends JpaRepository<Warranty, Long> {
}