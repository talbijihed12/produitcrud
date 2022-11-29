package com.example.examenblan.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classe")
public class Classe implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int codeClasse;
        @NotNull
        private String titre;
        @NotNull
        @Enumerated(EnumType.STRING)
        private Niveau niveau;
        @OneToMany(mappedBy="classe")
        private Set<CoursClassroom>cours;


    }
