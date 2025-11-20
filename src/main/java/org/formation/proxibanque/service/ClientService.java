package org.formation.proxibanque.service;

import org.formation.proxibanque.model.Client;
import org.formation.proxibanque.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        verifierClientFortune(client);
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'id: " + id));

        client.setNom(clientDetails.getNom());
        client.setPrenom(clientDetails.getPrenom());
        client.setAdresse(clientDetails.getAdresse());
        client.setCodePostal(clientDetails.getCodePostal());
        client.setVille(clientDetails.getVille());
        client.setTelephone(clientDetails.getTelephone());
        client.setEmail(clientDetails.getEmail());

        verifierClientFortune(client);

        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'id: " + id));
        clientRepository.delete(client);
    }

    public List<Client> getClientsByConseiller(Long conseillerId) {
        return clientRepository.findByConseillerId(conseillerId);
    }

    public List<Client> getClientsFortunes() {
        return clientRepository.findClientsFortunes();
    }

    public List<Client> searchClientsByName(String nom) {
        return clientRepository.findByNomContainingIgnoreCase(nom);
    }

    private void verifierClientFortune(Client client) {
        double soldeTotal = client.getSoldeTotal();
        client.setClientFortune(soldeTotal > 500000);
    }

    public void recalculerClientsFortunes() {
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            verifierClientFortune(client);
        }
        clientRepository.saveAll(clients);
    }
}