/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_vanmullem_larnac;

/**
 *
 * @author Anaëlle
 */
public class PlateauDeJeu {//création de la classe plateau de jeu
    CelluleDeGrille[][] grille = new CelluleDeGrille [6][7];//on créer un tableau de 6par 7
// 6 est le nombre de lignes
// 7 est le nombre de colonnes
    public PlateauDeJeu() {//constructeur de la classe
     for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                grille [i][j]=new CelluleDeGrille();//initialise untableau de 42 cases
            }
        }  
    }
    
    public int ajouterJetonDansColonne(Jeton j, int c){//
        for(int i=0;i<7;i++){//on balaie les lignes
            if(grille[i][c].presenceJeton()==false){//si la case est libre
                grille[i][c].affecterJeton(j);//on peut y mettre un jeton
                return i;
            }
            
        }
   return -1;   //on rajoute pour ne pas créer un bug  
    }
    
    
    public boolean grilleRempli(){//on regarde si la grille est pleine
        int cpt=0;//on initialise le compteur à 0
        for(int i=0;i<6;i++){//on balaie les lignes
            for(int j=0;j<7;j++){//on balaie les colonnes
                if(grille[i][j]!=null){//si il y a quelquechoses
                    cpt+=1;//on incrémente le compteur
                }
            }
        }
    if (cpt==42){//si le tableau est plein
        return true;//c'est rempli
    }else{
        return false;//c'est pas rempli
    }   
    }

    public String afficherGrilleSurConsole(){//affichage dans la fenetre de commande
        return "PlateauDeJeu{" + "grille=" + grille + '}';
    }

public boolean presenceJeton(int x, int y){//regarde si pour une case donnée la case est vide ou pleine
    if (grille[x][y]!=null){//si la case n'est pas vide
    return true;//la case est occupée
}else{
    return false;//la case est vide
}
}
public String lireCouleurDuJeton(int x, int y){//renvie la couleur du jeton sur une case
    grille[x][y].LireCouleurDuJeton();//on prend l'info grâce à la méthide lire couleurddu jeton
    return grille[x][y].LireCouleurDuJeton();
}
//dans les 4 méthodes suivantes, on cherche à savoir si 4 pions sont alignés
public boolean ligneGagnantePourCouleur(String Couleur){//en ligne
    boolean verification =false;
    int cpt=0;
    for(int i=0;i<3;i++){//on balaye les lignes jusqu'à 3 (en considérant que le if va jusqu'à la 3eme) c'est aussi pour ne pas déborder
    for(int c=0;c<7;c++){//on balaye les colonnes 
        if(grille[i][c].LireCouleurDuJeton()==grille[i+1][c].LireCouleurDuJeton()&&grille[i+2][c].LireCouleurDuJeton()==grille[i+3][c].LireCouleurDuJeton()){
        //on ckeck sur la meme colonne chaque hauteur de ligne : i, i+1;i+2;i+3;
        //si i=1 on check jusqu'à la ligne 4
        //si i=2 on ckeck jusqu'à la ligne 6 (grace aux conditions du if)
            cpt=1;//si il les conditions sont respectées alors on fixe le cpt à 1 
        }
    }
    }
  if (cpt==1){//si les conditions sont respectées (il y a 4 jetons alignés) 
      verification=true;//on passe à true
}
        return verification;
}
//meme prinicipe 
public boolean colonneGagnantePourCouleur(String a){
    boolean verification =false;
    int cpt=0;
    for(int i =0;i<3;i++){
        for(int c=0;c<7;i++){
            if(grille[i][c].LireCouleurDuJeton()==grille[i+1][c].LireCouleurDuJeton()){
                if(grille[i+1][c].LireCouleurDuJeton()==grille[i+2][c].LireCouleurDuJeton()){
                    if(grille[i+2][c].LireCouleurDuJeton()==grille[i+3][c].LireCouleurDuJeton()){
                        cpt=1;
                        //c'est les colonnes qui varie
                    }
                }
            }
        }
    }
    if(cpt==1){
        verification=true;
    }  
    return verification;
}
//meme principe
public boolean diagonaleMontanteGagnantePourCouleur(String b){
    boolean verification=false;
    int cpt=0;
    for(int i=0;i<3;i++){
        for(int c=0;c<4;c++){//on a que jusqu'à c=3 pour ne pas sortir du tableau
            //on fait varier les lignes et colonnes pour monter dans le tableau
            if (grille[i][c].LireCouleurDuJeton()==grille[i+1][c+1].LireCouleurDuJeton()){
                if(grille[i+1][c+1].LireCouleurDuJeton()==grille[i+2][c+2].LireCouleurDuJeton()){
                    if (grille[i+2][c+2].LireCouleurDuJeton()==grille[i+3][i+3].LireCouleurDuJeton()){
                        cpt=1;
                    }
                }
            }
        }
    }
    if (cpt==1){
        verification=true;
    }    
    return verification;
    
}
//meme principe
public boolean diagonaleDesencanteGagnantePourCouleur(String d){
    boolean verification=false;
    int cpt=0;
    for(int i=0;i<3;i++){
        for(int c=0;c<7;i++){
            //on fait desndre de case dans le tableau
            if (grille[i][c].LireCouleurDuJeton()==grille[i-1][c+1].LireCouleurDuJeton()){
                if(grille[i-1][c+1].LireCouleurDuJeton()==grille[i-2][c-2].LireCouleurDuJeton()){
                    if(grille[i-2][c-2].LireCouleurDuJeton()==grille[i-3][c+3].LireCouleurDuJeton()){
                        cpt=1;
                    }   
                }
            }
        }
    }
       if (cpt==1){
           verification=true;
       }
    return verification;
}

public void tasserColonne(int c) {//quand un jeton disparait
    int nb_ligne = 0;
            for(int i = nb_ligne; i < 5; i++){//on s'arrete à 5 pour ne pas sortir du tableau 
                if(grille[i][c].presenceJeton()==false && grille[i+1][c].presenceJeton()==true){
                    grille[i][c] = grille[i+1][c];//si il n'y a plus de jeton on decale le jeton
                }
            }
}
public boolean colonneRemplie (int a){//on regarde si on peut encore ajouter un jeton dans la colonne
    int cpt=0;
    for(int i=0;i<7;i++){//on balaie les lignes
        if(grille[i][a].presenceJeton()==true){//si dans la colonne il y a un jeton
            cpt+=1;//on incrémente
        }
        if (cpt==7){//si la collone est pleine
            return true;
        }
    }
        return true;
}
//pour la case concernée on fait une des actions suivantes :

    public void supprimerTrouNoir(int i, int c){
        grille[i][c].supprimerTrouNoir();
    }

    public boolean presenceDesintegrateur(int x, int y){
        return(grille[x][y].presenceDesintegrateur());
    }

    public void placerDesintegrateur(int x, int y) {
        grille[x][y].placerDesintegrateur();
    }

    public void supprimeresentDegrateur(int x, int y) {
        grille[x][y].supprimerDesintegrateur();
    }

    public void supprimerJeton(int x, int y) {
        grille[x][y].supprimerJeton();
    }

    public Jeton recupererJeton(int x, int y){
        return(grille[x][y].recupererJeton());
    }

    public String lireJeton(int x, int y) {
        return (grille[x][y].LireCouleurDuJeton());
    }

    public boolean presenceTrouNoir(int x, int y){
        return grille[x][y].presenceTrouNoir()==true;
    }

    public void placerTrouNoir(int x, int y){
        grille[x][y].placerTrouNoir();
    }


}