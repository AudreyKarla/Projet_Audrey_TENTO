package org.formation.proxibanque.controller;

import org.formation.proxibanque.service.GestionPatrimoineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/patrimoine")
@CrossOrigin(origins = "http://localhost:3000")
public class GestionPatrimoineController {

    @Autowired
    private GestionPatrimoineService gestionPatrimoineService;

    @GetMapping("/clients-eligibles")
    public ResponseEntity<?> getClientsEligibles() {
        try {
            return ResponseEntity.ok(gestionPatrimoineService.getClientsEligiblesPatrimoine());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/recommandations/{clientId}")
    public ResponseEntity<?> getRecommandationsPatrimoine(@PathVariable Long clientId) {
        try {
            return ResponseEntity.ok(gestionPatrimoineService.getRecommandationsPatrimoine(clientId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/simuler-placements")
    public ResponseEntity<?> simulerPlacements(@RequestBody Map<String, Object> request) {
        try {
            double montant = Double.parseDouble(request.get("montant").toString());
            int duree = Integer.parseInt(request.get("duree").toString());

            Map<String, Double> simulations = gestionPatrimoineService.simulerPlacements(montant, duree);
            return ResponseEntity.ok(simulations);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}