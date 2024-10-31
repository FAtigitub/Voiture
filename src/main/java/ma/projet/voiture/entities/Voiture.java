package ma.projet.voiture.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.voiture.entities.Client;
import org.springframework.data.annotation.Id;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private Long id;
    private String marque;
    private String matricule;
    private String model;
    private Long id_client;

    @Transient
    @ManyToOne
    private Client client;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return id;
    }

    public void setClientId(Long clientId) {
        this.id = id;
    }
    }



