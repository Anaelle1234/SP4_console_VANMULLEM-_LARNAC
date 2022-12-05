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
    
    public void  placerTrousNoirsEtDesintegrateurs() {

    // placement des 3 trous noirs et désintégrateur
    for (int i=0;i<3;i++){ // i fais 3 cas ( i prend 0 puis 1 puis 2 )
            Random R1=new Random(); //création objet R1 aleatoire
            int lg = R1.nextInt(7); //choix ligne aleatoirement
            
            Random R2=new Random();
            int cl = R2.nextInt(6); //choix colonne aleatoirement
        
        // s'il y a ni trou noir ni desintegrateur
        if (plateau.presenceTrouNoir(lg,cl)==false && plateau.presenceDesintegrateur(lg,cl)==false)  {
              plateau.placerTrouNoir(lg,cl); //on place un trou noir de même coord que le desintegrateur
              plateau.placerDesintegrateur(lg,cl); //on place un desintegrateur de même coord que le trou noir
        }
    }

    // placement des deux autres trous noirs et desintegrateur
    for(int j=0;j<2;j++){ //j fais 2 cas (j prend 0 puis 2)
        Random R3=new Random(); //choix aleatoire de R3
        int l_tn = R3.nextInt(7);
        
        Random R4=new Random();
        int c_tn = R4.nextInt(6);
        
        Random R5=new Random();
        int l_des = R5.nextInt(7);
        
        Random R6=new Random();
        int c_des = R6.nextInt(6);

        if (plateau.presenceTrouNoir(l_tn,c_tn)==false && plateau.presenceDesintegrateur(l_tn,c_tn)==false )  {
            plateau.placerTrouNoir(l_tn,c_tn); //"false" car on place un trou noir si il n'y a rien 
        }

        if (plateau.presenceDesintegrateur(l_des,c_des)==false &&plateau.presenceTrouNoir(l_des,c_des)==false)  {
            plateau.placerDesintegrateur(l_des,c_des);//pareil que pour les trous noirs
        }
    }
}    

    public void initialiserPartie(){
        
        attribuerCouleurAuxJoueurs(); //définit quel joueur est rouge ou jaune
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs() ; // placement des éléments du jeu

    }
    
    public void lancerPartie() {
        
        Scanner sc = new Scanner(System.in);
        this.initialiserPartie(); //utilisation methode initialiser partie
        int nLigne;
        
        if (plateau.grilleRempli()== false) { // si la grille renvoie false alors elle est vide
            
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
                    int ligneJeton = sc.nextInt(); //récupère la réponse du joueur
                    int colJeton = sc.nextInt();
                    
                    //CAS OU IL Y A UN JETON
                    if (plateau.lireJeton(ligneJeton, colJeton).equals(joueurCourant.lireCouleur())) {
                        plateau.recupererJeton(ligneJeton, colJeton);
                        System.out.println("Jeton récupéré.");
                        break;
                    
                    // CAS OU IL N'Y A PAS DE JETON                
                    } else if (plateau.presenceJeton(ligneJeton, colJeton)==false) { 
                        System.out.println("Aucun jeton sur cette case.");
                    
                    // RESTE : CAS OU CE N'EST PAS LE JETON DU JOUEUR
                    } else {
                        System.out.println("Ce n'est pas un de vos jetons.");
                    }
                        
                case 3: //cas où la réponse est 3)
                    
                    //CAS OU LE JOUER N'A PAS DE DESINTEGRATEUR
                    if (joueurCourant.nombreDesintegrateurs == 0) { //A REVOIR
                        System.out.println("Vous n'avez pas de desintagrateur.");
                        break;
                    
                    //CAS OU LE JOUEUR PEUT DESINTEGRER UN JETON
                    } else {
                        System.out.println("Vous devez choisir une case." );
                        System.out.println("Entrez le numéro de la ligne entre 1 et 6 :"); //coord ligne
                        int ligneDes = sc.nextInt(); //récupère les coordonnées du joueur
                        System.out.println("Entrez le numéro de la colonne entre 1 et 7 :"); //coord colonne
                        int colDes = sc.nextInt();
                        
                        if (plateau.presenceJeton(ligneDes, colDes)){ // seulement s'il y a un jeton dans la case visée
                            plateau.supprimerJeton(ligneDes, colDes); // vise le jeton à supprimer
                            joueurCourant.utiliserDesintegrateur(); // supression du jeton avec methode utiliserdesintegrateur
                            break;
                        
                        // CAS OU PAS DE JETON
                        } else {
                            System.out.println("Il n'y a pas de jeton sur cette case.");
                        }
                    }
            }

        }
    }

}

