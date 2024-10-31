package ma.projet.voiture.services;

import ma.projet.voiture.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Annotation indiquant que cette interface utilise Feign pour se connecter au service-client
@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {

    // Méthode pour récupérer un client par son ID depuis le microservice service-client
    @GetMapping(path = "/clients/{id}")
    Client clientById(@PathVariable("id") Long id);
}
