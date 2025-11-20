package org.formation.proxibanque.controller;

import org.formation.proxibanque.dto.VirementRequest;
import org.formation.proxibanque.service.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/virements")
@CrossOrigin(origins = "http://localhost:3000")
public class VirementController {

    @Autowired
    private VirementService virementService;

    @PostMapping("/effectuer")
    public ResponseEntity<Map<String, Object>> effectuerVirement(@RequestBody VirementRequest virementRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            boolean succes = virementService.effectuerVirement(
                    virementRequest.getCompteSource(),
                    virementRequest.getCompteDestination(),
                    virementRequest.getMontant()
            );

            response.put("success", succes);
            response.put("message", "Virement effectué avec succès");
            response.put("montant", virementRequest.getMontant());
            response.put("compteSource", virementRequest.getCompteSource());
            response.put("compteDestination", virementRequest.getCompteDestination());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/verifier-solde/{numeroCompte}")
    public ResponseEntity<Map<String, Object>> verifierSolde(@PathVariable String numeroCompte) {
        Map<String, Object> response = new HashMap<>();

        try {
            double solde = virementService.getSoldeCompte(numeroCompte);
            response.put("numeroCompte", numeroCompte);
            response.put("solde", solde);
            response.put("success", true);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/verifier-virement")
    public ResponseEntity<Map<String, Object>> verifierVirement(@RequestBody VirementRequest virementRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            boolean soldeSuffisant = virementService.verifierSoldeSuffisant(
                    virementRequest.getCompteSource(),
                    virementRequest.getMontant()
            );

            response.put("soldeSuffisant", soldeSuffisant);
            response.put("message", soldeSuffisant ? "Solde suffisant" : "Solde insuffisant");
            response.put("success", true);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}