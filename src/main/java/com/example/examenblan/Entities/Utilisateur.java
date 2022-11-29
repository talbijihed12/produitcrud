package com.example.examenblan.Entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idUtilisateur;
        @NotNull
        private String nom;
        @NotNull
        private String prenom;
        @NotNull
        private String password;
        @ManyToOne(cascade = CascadeType.ALL)
        private Classe classe;
}
