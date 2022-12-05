/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_vanmullem_larnac;

/**
 *
 * @author Anaëlle
 */
public class PlateauDeJeu {
    CelluleDeGrille[][] grille = new CelluleDeGrille [6][7];

    public PlateauDeJeu() {
     for(int i=0;i<=6;i++){
            for(int j=0;i<=7;i++){
                grille [i][j]=new CelluleDeGrille ();
            }
        }  
    }
    
    public int ajouterJetonDansColonne(Jeton j, int c){
        for(int i=0;i<7;i++){
            if(grille[i][c].presenceJeton()==false){
                grille[i][c].affecterJeton(j);
                return i;
            }
            
        }
   return -1;     
    }
    
    
    public boolean grilleRempli(){
        int cpt=0;
        for(int i=0;i<=6;i++){
            for(int j=0;i<=7;i++){
                if(grille[i][j]!=null){
                    cpt+=1;
                }
            }
        }
    if (cpt==42){
        return true;
    }else{
        return false;
    }   
    }

    public String afficherGrilleSurConsole(){
        return "PlateauDeJeu{" + "grille=" + grille + '}';
    }

public boolean presenceJeton(int x, int y){
    if (grille[x][y]!=null){
    return true;
}else{
    return false;
}
}
public String lireCouleurDuJeton(int x, int y){
    grille[x][y].LireCouleurDuJeton();
    return grille[x][y].LireCouleurDuJeton();
}

public boolean ligneGagnantePourCouleur(String Couleur){
    boolean verification =false;
    int cpt=0;
    for(int i=0;i<3;i++){
    for(int c=0;c<7;c++){
        if(grille[i][c].LireCouleurDuJeton()==grille[i+1][c].LireCouleurDuJeton()&&grille[i+2][c].LireCouleurDuJeton()==grille[i+3][c].LireCouleurDuJeton()){
        cpt=1;    
        }
    }
    }
  if (cpt==1){
      verification=true;
}
        return verification;
}

public boolean colonneGagnantePourCouleur(String a){
    boolean verification =false;
    int cpt=0;
    for(int i =0;i<3;i++){
        for(int c=0;c<7;i++){
            if(grille[i][c].LireCouleurDuJeton()==grille[i+1][c].LireCouleurDuJeton()){
                if(grille[i+1][c].LireCouleurDuJeton()==grille[i+2][c].LireCouleurDuJeton()){
                    if(grille[i+2][c].LireCouleurDuJeton()==grille[i+3][c].LireCouleurDuJeton()){
                        cpt=1;
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

public boolean diagonaleMontanteGagnantePourCouleur(String b){
    boolean verification=false;
    int cpt=0;
    for(int i=0;i<3;i++){
        for(int c=0;c<4;c++){
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

public boolean diagonaleDesencanteGagnantePourCouleur(String d){
    boolean verification=false;
    int cpt=0;
    for(int i=0;i<3;i++){
        for(int c=0;c<7;i++){
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

public void tasserColonne(int c) {
    int nb_ligne = 0;
            for(int i = nb_ligne; i < 8; i++){
                if(grille[i][c].presenceJeton()==false && grille[i+1][c].presenceJeton()==true){
                    grille[i][c] = grille[i+1][c];
                }
            }
}
public boolean colonneRemplie (int a){
    int cpt=0;
    for(int i=0;i<7;i++){
        if(grille[i][a].presenceJeton()==true){
            cpt+=1;
        }
        if (cpt==7){
            return true;
        }
    }
        return true;
}

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
        return(grille[x][y].presenceTrouNoir());
    }

    public void placerTrouNoir(int x, int y){
        grille[x][y].placerTrouNoir();
    }



}