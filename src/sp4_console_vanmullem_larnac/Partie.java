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
        this.initialiserPartie(); //utilisation methode initialiser partie
        int nLigne;
        
        if (plateau.grilleRempli()== false) { // si la grille renvoie false alors elle est vide
            joueurCourant.AffecterCouleur(couleur); //chaque joueur prennent une couleur

            System.out.println("Que souhaitez vous faire ?" + '\n' + " 1) Jouer un jeton." + '\n' + "2) Récupérer un jeton."+ '\n' + "3) Utiliser un Desintegrateur.");
            int rep_1 = sc.nextInt(); // permet d'enregistrer et lire la réponse de l'utilisateur
                
            switch (rep_1) {
                    
                case 1: //cas où reponse 1)
                    
                    System.out.println("Choisissez le numéro de la colonne sur laquelle vous souhaitez jouer." + '\n' + "Entrez un chiffre entre 1 et 7");
                    int col = sc.nextInt(); // permet d'enregistrer et lire la réponse de l'utilisateur
                    
                    // CAS OU LA COLONNE EST REMPLIE
                    while (plateau.presenceJeton(6, col)) { //vérifie s'il y a des jetons en dernière ligne de la colonne choisie 
                        // si un jeton est présent dans la colonne choisie et dans la dernière ligne du haut
                        // alors la colonne est forcément remplie
                        System.out.println("Colonne remplie" + '\n' + "Choisissez une autre colonne");
                        col = sc.nextInt();
                    }
       
                        // CAS OU COLONNE NON REMPLIE
                    boolean boucle = true;
                    int i = 0;
                    while (boucle && i < 7){ 
                    //boucle while au lieu de for pour pouvoir sortir de la boucle une fois la ligne définie
                    // ça évite d'utiliser un break
                        
                        if(!plateau.presenceJeton(i, col)){ 
                        //verifie la présence d'unjeton dans chaque ligne de la colonne choisie pour definir ses coord.
                            nLigne = i; 
                            // si pas de jeton alors le numero de la ligne vide sera la coordonnee du jeton à placer
                        } 
                        
                        if(!plateau.presenceTrouNoir(nLigne, col)) {  
                        //ajouter le jeton 
                            Jeton NouveauJeton = joueurCourant.jouerJeton();
                            plateau.ajouterJetonDansColonne(NouveauJeton, col);
                        }
                        
                        if (i==nLigne) boucle = false; // condition pour ne pas reboucler (remplace break)
                        i++; // i prends +1
                    
                    }

            
                        
                case 2: //cas où la réponse est 2)
                    
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
                        if (plateau.presenceJeton(ligne_d, col_d)){ 
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
