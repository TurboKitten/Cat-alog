package com.example.cat_alog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gatos")
public class Gato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int gatoid;

    @NotNull
    int años;
    
    @NotNull
    int meses;

    @NotBlank
    String raza;

    @NotBlank
    String color; 

    @NotBlank
    String pelaje;

    @NotBlank
    String personalidad;

    @OneToOne(mappedBy="usuarioid", )
    private Usuario tutor; 
}
