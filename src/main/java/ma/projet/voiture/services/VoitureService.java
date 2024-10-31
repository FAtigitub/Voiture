package ma.projet.voiture.services;

import ma.projet.voiture.entities.Client;
import ma.projet.voiture.entities.Voiture;
import ma.projet.voiture.repositories.VoitureRepository;
import ma.projet.voiture.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {

    private final ClientService clientService;
    private VoitureRepository voitureRepository;

    @Autowired
    public VoitureService(ClientService clientService) {
        this.clientService = clientService;
    }

    public Client obtenirClientParId(Long id) {
        return clientService.clientById(id);
    }

    public Voiture enregistrerVoiture(Voiture voiture) {
        // Save the Voiture entity to the database
        return voitureRepository.save(voiture);
    }

}
