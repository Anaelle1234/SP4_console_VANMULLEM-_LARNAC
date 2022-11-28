/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_vanmullem_larnac;

import java.util.ArrayList;

/**
 *
 * @author Anaëlle
 */
public class joueur {
    private String nom;
    private String couleur;
    private ArrayList<Jeton> reserveJetons = new ArrayList<Jeton>();
    private int nombreDesintegrateurs;

    public joueur(String nom, int nombreDesintegrateurs) {
        nombreDesintegrateurs=0;
        this.nom = nom;
        this.nombreDesintegrateurs = nombreDesintegrateurs;
    }
 public void AffecterCouleur(String Couleur){
     if(Couleur=="jaune" || Couleur=="rouge"){
         this.couleur =couleur;
     }
 }
 public int nombreDeJetons(){
     return reserveJetons.size();
 }
 public void ajouterJeton(Jeton j){
     reserveJetons.add(j);
 }
 public Jeton jouerJeton(){
     Jeton remove = reserveJetons.remove(0);
     return remove;        
 }
 
 public int obtenirDesintegrateur(){
     nombreDesintegrateurs+=1;
        return nombreDesintegrateurs;
 }
 public int utiliserDesintegrateur(){
     nombreDesintegrateurs-=1;
     return nombreDesintegrateurs;
 }
}

