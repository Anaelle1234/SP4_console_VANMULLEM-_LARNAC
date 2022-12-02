/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_vanmullem_larnac;

import java.util.Random;

/**
 *
 * @author Soso
 */
public class Partie {
    
    private String listeJoueurs[]= new String[2]; //tableau référence des deux joueurs 
    private joueur joueurCourant;
    private PlateauDeJeu plateau;
    
    public void Partie(joueur Joueur) {
        listeJoueurs[0]="Joueur";
        listeJoueurs[1]="Joueur";
        
        plateau = new PlateauDeJeu();
        
    }
    
    public void attribuerCouleurAuxJoueurs() {
        Random n = new Random();
        int nbr = n.nextInt(2); // choisie aléatoirement entre 1 et 2
        
        if (nbr==1) {
            listeJoueurs[0] = "Rouge";
            listeJoueurs[1] = "Jaune";            
        }else{ // si nbr==2
            listeJoueurs[0] = "Jaune";
            listeJoueurs[1] = "Rouge";
        }
    }
    
    public void creerEtAffecterJeton(joueur Joueur) {
        
        
    }
}
