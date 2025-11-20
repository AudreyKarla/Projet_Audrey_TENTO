-- Insertion des agences
INSERT INTO agence (id_agence, date_creation) VALUES ('AG001', '2020-01-15');
INSERT INTO agence (id_agence, date_creation) VALUES ('AG002', '2021-03-20');

-- Insertion des conseillers
INSERT INTO conseiller (nom, prenom, email, telephone, agence_id) VALUES ('Dupont', 'Marie', 'marie.dupont@proxibanque.fr', '01 23 45 67 89', 'AG001');
INSERT INTO conseiller (nom, prenom, email, telephone, agence_id) VALUES ('Martin', 'Pierre', 'pierre.martin@proxibanque.fr', '01 34 56 78 90', 'AG001');
INSERT INTO conseiller (nom, prenom, email, telephone, agence_id) VALUES ('Bernard', 'Sophie', 'sophie.bernard@proxibanque.fr', '02 12 34 56 78', 'AG002');

-- Mise à jour des gérants d'agence
UPDATE agence SET gerant_id = 1 WHERE id_agence = 'AG001';
UPDATE agence SET gerant_id = 3 WHERE id_agence = 'AG002';

-- Insertion des clients
INSERT INTO client (nom, prenom, adresse, code_postal, ville, telephone, email, client_fortune, conseiller_id) VALUES
   ('Durand', 'Jean', '123 Rue de la Paix', '75001', 'Paris', '01 45 67 89 01', 'jean.durand@email.fr', false, 1),
   ('Moreau', 'Alice', '456 Avenue des Champs', '75008', 'Paris', '01 56 78 90 12', 'alice.moreau@email.fr', true, 1),
   ('Leroy', 'Paul', '789 Boulevard Saint-Germain', '75006', 'Paris', '01 67 89 01 23', 'paul.leroy@email.fr', false, 2),
   ('Petit', 'Isabelle', '321 Rue de Rivoli', '75004', 'Paris', '01 78 90 12 34', 'isabelle.petit@email.fr', false, 3),
   ('Roux', 'Michel', '654 Rue du Faubourg', '75010', 'Paris', '01 89 01 23 45', 'michel.roux@email.fr', true, 3);

-- Insertion des comptes courants
INSERT INTO compte (dtype, numero_compte, solde, date_ouverture, client_id, decouvert_autorise) VALUES
    ('CompteCourant', 'CC10001', 2500.00, '2023-01-10', 1, 1000.0),
    ('CompteCourant', 'CC10002', 750000.00, '2023-02-15', 2, 1000.0),
    ('CompteCourant', 'CC10003', 1500.00, '2023-03-20', 3, 1000.0),
    ('CompteCourant', 'CC10004', 3200.00, '2023-04-25', 4, 1000.0),
    ('CompteCourant', 'CC10005', 600000.00, '2023-05-30', 5, 1000.0);

-- Insertion des comptes épargne
INSERT INTO compte (dtype, numero_compte, solde, date_ouverture, client_id, taux_remuneration) VALUES
   ('CompteEpargne', 'CE20001', 5000.00, '2023-01-10', 1, 3.0),
   ('CompteEpargne', 'CE20002', 100000.00, '2023-02-15', 2, 3.0),
   ('CompteEpargne', 'CE20003', 3000.00, '2023-03-20', 3, 3.0),
   ('CompteEpargne', 'CE20004', 8000.00, '2023-04-25', 4, 3.0),
   ('CompteEpargne', 'CE20005', 150000.00, '2023-05-30', 5, 3.0);

-- Insertion des cartes bancaires
INSERT INTO carte_bancaire (numero_carte, active, type_carte, client_id, compte_id) VALUES
    ('4532-1234-5678-1001', true, 'VISA_ELECTRON', 1, 1),
    ('4916-2345-6789-2001', true, 'VISA_PREMIER', 2, 2),
    ('4556-3456-7890-3001', true, 'VISA_ELECTRON', 3, 3),
    ('4929-4567-8901-4001', true, 'VISA_PREMIER', 4, 4),
    ('4539-5678-9012-5001', true, 'VISA_PREMIER', 5, 5);