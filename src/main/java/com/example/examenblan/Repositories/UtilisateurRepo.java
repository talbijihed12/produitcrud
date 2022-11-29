package com.example.examenblan.Repositories;

import com.example.examenblan.Entities.Niveau;
import com.example.examenblan.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Integer> {
    Integer countByClasseNiveau(Niveau nv);
}
