/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_vanmullem_larnac;

/**
 *
 * @author Anaëlle
 */
public class Jeton {
private String Couleur;
    public Jeton(String Couleur) {
        this.Couleur = Couleur;
    }
  public String lireCouleur(){
      return(Couleur);   
  }  

    @Override
    public String toString() {
        if (Couleur=="rouge"){
            Couleur="R";
        }else if (Couleur =="jaune"){
            Couleur="J";   
        }
        return "Jeton{" + "Couleur=" + Couleur + '}';
    }
  
}

  
   
    
