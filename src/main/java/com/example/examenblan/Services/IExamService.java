package com.example.examenblan.Services;

import com.example.examenblan.Entities.Classe;
import com.example.examenblan.Entities.CoursClassroom;
import com.example.examenblan.Entities.Niveau;
import com.example.examenblan.Entities.Utilisateur;
import org.springframework.stereotype.Service;

@Service

public interface IExamService {

    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);

    Classe ajouterClasse(Classe c);

    CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse);

    void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse);

    Integer nbUtilisateursParNiveau(Niveau nv);

    void archiverCoursClassrooms();
}
