package org.myApps.customerMicroService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {
    /*
    * à noter que les objets dto font partie des bonnes pratiques, elle permettent d'éviter l'utilisation des
    * entités JPA dans les GUI [les entités JPA causent des problèmes. exemple: la scalabilité i.e si je
    * veut pas qu'un attribut apparaiise sur la GUI, je dois inclure des annotations pour l'ignorer, alors
    * qu'en utilisant les DTO, je peut facilement le supprimer du code, et le mapper ne va pas l'ajouter dans
    * la GUI]
    */
    private String id;
    private String name;
    private String email;
}
