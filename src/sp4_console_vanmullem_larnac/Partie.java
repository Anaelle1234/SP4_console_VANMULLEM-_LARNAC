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
    
    private joueur listeJoueurs[]= new joueur[2]; //tableau référence des deux joueurs 
    private joueur joueurCourant;
    private PlateauDeJeu plateau;
    
    public void Partie(joueur joueur1, joueur joueur2) {
        listeJoueurs[0]=joueur1;
        listeJoueurs[1]=joueur2;
        
        plateau = new PlateauDeJeu();
        
    }
    
    public void attribuerCouleurAuxJoueurs() {
        Random n = new Random();
        int nbr = n.nextInt(2); // choisie aléatoirement entre 1 et 2
        
        if (nbr==1) {
            listeJoueurs[0].AffecterCouleur("rouge"); //methode AffecterCouleur de la classe joueur
            listeJoueurs[1].AffecterCouleur("jaune");        
        }else{ // si nbr==2
            listeJoueurs[0].AffecterCouleur("jaune");
            listeJoueurs[1].AffecterCouleur("rouge");
        }
    }
    
    public void creerEtAffecterJeton(joueur jr) {
        for (int i=1; i<=30; i++){
            Jeton jeton_i = new Jeton (jr.lireCouleur()); //création obj jetoni 
            jr.ajouterJeton(jeton_i);
        }
        
    }
    
    public void placerTrousNoirsEtDesintegrateurs(){
        
    }
    
    public void initialiserPartie(){
        
    }
}
