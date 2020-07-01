package be.sander.thuis.repositories;

import be.sander.thuis.domain.Kattenbak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface KattenbakRepository extends JpaRepository<Kattenbak, Long>{
   Long countByNaam(String naam);

   @Query("select v from Kattenbak v order by v.datum asc ")
   List<Kattenbak> findAllByDatum();
}
