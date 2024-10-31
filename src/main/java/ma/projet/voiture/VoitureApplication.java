package ma.projet.voiture;


import ma.projet.voiture.entities.Client;
import ma.projet.voiture.entities.Voiture;
import ma.projet.voiture.repositories.VoitureRepository;
import ma.projet.voiture.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@EnableDiscoveryClient
@EnableFeignClients // Activer Feign pour ce microservice
@SpringBootApplication
public class VoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
        return args -> {
            // Récupération des clients par ID
            Client c1 = clientService.clientById(2L);
            Client c2 = clientService.clientById(1L);

            // Affichage des informations sur le client c2
            System.out.println("**************************");
            System.out.println("Id est :" + c2.getId());
            System.out.println("Nom est :" + c2.getNom());
            System.out.println("**************************");

            // Affichage des informations sur le client c1
            System.out.println("**************************");
            System.out.println("Id est :" + c1.getId());
            System.out.println("Nom est :" + c1.getNom());
            System.out.println("Age est :" + c1.getAge());
            System.out.println("**************************");

            // Enregistrement d'une voiture associée au client c2
            voitureRepository.save(new Voiture(1L, "Toyota", "A 25 333", "Corolla", 1L, c2));
        };
    }
}


    // Interface pour accéder au service-client

