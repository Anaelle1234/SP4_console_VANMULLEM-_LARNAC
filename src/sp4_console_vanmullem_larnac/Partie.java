/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_vanmullem_larnac;

import java.util.Random;
import java.util.Scanner;

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
        int n = 0;
        int m = 0;
        int i = 0;
        if (i < 3) {
            plateau.placerTrouNoir(n, m);
                if (i > 2) {
                    plateau.placerTrouNoir(n,m);
                    plateau.presenceTrouNoir(n, m);
                    plateau.placerDesintegrateur(n, m);
                    plateau.presenceDesintegrateur(n, m);
                }

            }
        }
    
    public void initialiserPartie(){ 
        attribuerCouleurAuxJoueurs();
        creeEtAffecterJeton(jeton_1); //Revoir nomination joueur...
        creeEtAffecterJeton(jeton_2);
        placerTrousNoirsEtDesintegrateurs();
    }
 
    public void lancerPartie() { //REVOIR
        Scanner sc = new Scanner(System.in);
        this.initialiserPartie();
        while (true) {
            if (!plateau.grilleRemplie()) { // CORRIGER DANS LA CLASSE PLATEAU
                joueurCourant = tab[0];

                System.out.println("Que souhaitez vous faire ?"
                        + '\n' + " 1) Jouer un jeton." + '\n' + "2) Récupérer un jeton."+ '\n' + "3) Utiliser un Desintegrateur.");
                int rep_1 = sc.nextInt();
                
                switch (rep_1) {
                    
                    case 1:
                        System.out.println("Sur qu'elle colonne voulez vous jouez ? " + '\n' + "Entrez un chiffre entre 1 et 7");
                        int col = sc.nextInt();
                        if (plateau.presenceJeton(col, 6)) {
                            System.out.println("Colonne remplie" + '\n' + "Choisissez une autre colonne");
                        } else{
                            for(int i = 0; i < 7; i++){
                                if(!plateau.presenceJeton(i, col)){
                                    int ligne = i;
                                    break;
                                }
                            }
                        }
                        //Erreur si la colonne est plein il ne revient pas au dÃ©but du case 

                        if(plateau.presenceTrouNoir(col, col)) {                      
                            Jeton jeton_param = joueurCourant.jouerJeton();
                            plateau.ajouterJetonDansColonne(jeton_param, col);
                        }
                        
                    case 2:
                        System.out.println("Choisissez un de vos jetons" + '\n' + "Exprimer la coordonnée en Ligne puis Colonne");
                        int ligne_r = sc.nextInt();
                        int col_r = sc.nextInt();
                        if (plateau.lireJeton(ligne_r, col_r).equals(joueurCourant.lireCouleur())) {
                            joueurCourant.ajouterJeton(plateau.recupererJeton(ligne_r, col_r));
                            System.out.println("Jeton récupéré.");
                            break;
                        } else if (plateau.lireJeton(ligne_r, col_r).equals("n")) {
                            System.out.println("Aucun jeton sur cette case.");
                        } else {
                            System.out.println("Ce n'est pas un de vos jetons.");
                        }
                        
                    case 3:
                        if (joueurCourant.nombreDesintegrateurs == 0) { //A REVOIR
                            System.out.println("Vous n'avez pas de desintagrateur.");
                            break;
                        } else {
                            System.out.println("Choisissez une case" + '\n' + "Exprimer la en coordonnée Ligne puis Colonne");
                            int ligne_d = sc.nextInt();
                            int col_d = sc.nextInt();
                            if (plateau.presenceJeton(ligne_d, col_d)) {
                                plateau.supprimerJeton(ligne_d, col_d);
                                joueurCourant.utiliserDesintegrateur();
                                break;
                            } else {
                                System.out.println("Il n'y a pas de jeton sur cette case.");
                            }
                        }
                        System.out.println("Sur qu'elle colonne voulez vous jouez ? " + '\n' + "Entrez un chiffre entre 1 et 7");
                }

                int col = sc.nextInt();
                String couleur = joueurCourant.lireCouleur();
                Jeton jeton_param = joueurCourant.jouerJeton();
                plateau.ajouterJetonDansColonne(jeton_param, col);

            }
        }

    }
}
