package com.example.examenblan.Controller;

import com.example.examenblan.Entities.Classe;
import com.example.examenblan.Entities.CoursClassroom;
import com.example.examenblan.Entities.Niveau;
import com.example.examenblan.Entities.Utilisateur;
import com.example.examenblan.Services.IExamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ExamController {
    private IExamService iExamService;

    @PostMapping("/addexam")
    Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        return iExamService.ajouterUtilisateur(utilisateur);
    }

    @PostMapping("/addclass")
    Classe ajouterClasse(@RequestBody Classe c) {
        return iExamService.ajouterClasse(c);
    }

    @PostMapping("/addclassroom/{codeClasse}")
    CoursClassroom ajouterCoursClassroom(@RequestBody CoursClassroom cc, @PathVariable Integer codeClasse) {
        return iExamService.ajouterCoursClassroom(cc, codeClasse);
    }

    @PostMapping("/affecterUtilisateur/{idUtilisateur}/{codeClasse}")
    void affecterUtilisateurClasse(@PathVariable Integer idUtilisateur, @PathVariable Integer codeClasse) {
        iExamService.affecterUtilisateurClasse(idUtilisateur, codeClasse);
    }

    @GetMapping("/nbrclasse")
    Integer nbUtilisateursParNiveau(Niveau niveau) {
        return iExamService.nbUtilisateursParNiveau(niveau);
    }
}


