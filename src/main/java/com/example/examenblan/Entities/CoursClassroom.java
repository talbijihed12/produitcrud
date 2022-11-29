package com.example.examenblan.Entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "coursClassroom")
public class CoursClassroom implements Serializable {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idCours;
        @NotNull
        private String nom;
        @NotNull
        private int nbrHeure;

        @Enumerated(EnumType.STRING)
        private Specialite specialite;
        private Boolean archive;
        @ManyToOne(cascade = CascadeType.ALL)
        private Classe classe;


}
