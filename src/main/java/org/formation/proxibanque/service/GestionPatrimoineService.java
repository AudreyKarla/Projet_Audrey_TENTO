package org.formation.proxibanque.service;

import org.formation.proxibanque.model.Client;
import org.formation.proxibanque.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GestionPatrimoineService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientsEligiblesPatrimoine() {
        return clientRepository.findClientsFortunes();
    }

    public Map<String, Double> simulerPlacements(double montant, int dureeAnnees) {
        Map<String, Double> simulations = new HashMap<>();

        double rendementParis = 0.04;
        double rendementNewYork = 0.06;
        double rendementTokyo = 0.05;

        simulations.put("Paris", calculerRendement(montant, rendementParis, dureeAnnees));
        simulations.put("New-York", calculerRendement(montant, rendementNewYork, dureeAnnees));
        simulations.put("Tokyo", calculerRendement(montant, rendementTokyo, dureeAnnees));

        return simulations;
    }

    public Map<String, Object> getRecommandationsPatrimoine(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé: " + clientId));

        Map<String, Object> recommandations = new HashMap<>();
        double soldeTotal = client.getSoldeTotal();

        if (soldeTotal > 500000) {
            recommandations.put("eligible", true);
            recommandations.put("soldeTotal", soldeTotal);
            recommandations.put("message", "Client éligible à la gestion de patrimoine");
            recommandations.put("simulation_5_ans", simulerPlacements(soldeTotal, 5));
            recommandations.put("simulation_10_ans", simulerPlacements(soldeTotal, 10));
        } else {
            recommandations.put("eligible", false);
            recommandations.put("soldeTotal", soldeTotal);
            recommandations.put("message", "Client non éligible - Solde insuffisant");
        }

        return recommandations;
    }

    private double calculerRendement(double capital, double tauxAnnuel, int annees) {
        return capital * Math.pow(1 + tauxAnnuel, annees);
    }
}