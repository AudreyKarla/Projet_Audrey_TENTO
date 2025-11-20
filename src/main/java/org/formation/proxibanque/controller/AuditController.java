package org.formation.proxibanque.controller;

import org.formation.proxibanque.model.Audit;
import org.formation.proxibanque.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/audits")
@CrossOrigin(origins = "http://localhost:3000")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping("/agence/{agenceId}")
    public ResponseEntity<Audit> auditerAgence(@PathVariable String agenceId) {
        try {
            Audit audit = auditService.auditerAgence(agenceId);
            return ResponseEntity.ok(audit);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/comptes-debiteurs/particuliers")
    public ResponseEntity<?> getComptesParticuliersDebiteurs() {
        try {
            return ResponseEntity.ok(auditService.getComptesParticuliersDebiteurs());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/comptes-debiteurs/entreprises")
    public ResponseEntity<?> getComptesEntreprisesDebiteurs() {
        try {
            return ResponseEntity.ok(auditService.getComptesEntreprisesDebiteurs());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}