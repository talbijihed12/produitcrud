package com.example.examenblan.Services;

import com.example.examenblan.Entities.Classe;
import com.example.examenblan.Entities.CoursClassroom;
import com.example.examenblan.Entities.Niveau;
import com.example.examenblan.Entities.Utilisateur;
import com.example.examenblan.Repositories.ClasseRepo;
import com.example.examenblan.Repositories.CoursClassRepo;
import com.example.examenblan.Repositories.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExamService implements IExamService {
private UtilisateurRepo utilisateurRepo;
private ClasseRepo classeRepo;
private CoursClassRepo coursClassRepo;
@Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur){
    return  utilisateurRepo.save(utilisateur);
}
@Override
    public Classe ajouterClasse(Classe c){
    return classeRepo.save(c);
}
    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse){
        Classe classe = classeRepo.findById(codeClasse).orElse(null);
        cc.setClasse(classe);
        return coursClassRepo.save(cc);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        Utilisateur utilisateur =utilisateurRepo.findById(idUtilisateur).orElse(null);
        Classe classe = classeRepo.findById(codeClasse).orElse(null);
        utilisateur.setClasse(classe);
        utilisateurRepo.save(utilisateur);
    }
    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv){
    return utilisateurRepo.countByClasseNiveau(nv);
    }
    @Scheduled(cron = "*/60 * * * * *" )
    @Override
    public void archiverCoursClassrooms(){
    List<CoursClassroom> coursClassrooms= coursClassRepo.findAll();
    for (CoursClassroom coursClassroom:coursClassrooms){
        coursClassroom.setArchive(true);
        coursClassRepo.save(coursClassroom);
    }

    }

}
