package ma.projet.voiture.repositories;

import ma.projet.voiture.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    List<Voiture> findByClientId(Long id);
}
