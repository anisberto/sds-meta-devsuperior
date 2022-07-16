package br.com.anisberto.dsmeta.repository;

import br.com.anisberto.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalerRepository extends JpaRepository<Sale, Long> {
}
