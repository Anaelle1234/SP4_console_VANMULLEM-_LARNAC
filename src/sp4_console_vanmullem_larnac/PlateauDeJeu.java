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
        
    public CelluleDeGrille afficherGrilleSurConsole(){
        return null;
    }

    @Override
    public String toString() {
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
    grille[x][y].lireCouleurDuJeton();
    return grille[x][y].lireCouleurDuJeton();
}
//public etreGagnantePourCouleur(String){ // A REMPLIR
    
}

public void tasserColonne(int col) {
    int nb_ligne = 0;
    for(int i = 0; i < 8; i++){
        if(grille[i][col] == null){
            for (i = 0; i < 8; i++) {
                if (grille[i][col] == null) {
                    nb_ligne = i;
                    break;
                }
            }
            for(i = nb_ligne; i < 8; i++){
                if(grille[i][col] != null){
                    grille[i-1][col] = grille[i][col];
                        for (i = nb_ligne; i < 8; i++) { //REVOIR...
                            if (grille[i][col] != null) {
                                grille[i - 1][col] = grille[i][col];
                            }
                        }
                }
            }
        }
    }
}

    public boolean presenceTrouNoir(int x, int y){
        return(grille[x][y].presenceTrouNoir());
    }
    
    public void placerTrouNoir(int x, int y){
        grille[x][y].placerTrouNoir();
    }
    
    public void supprimerTrouNoir(int x, int y){
        grille[x][y].supprimerTrouNoir();
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
        return (grille[x][y].LireCouleurJeton());
    }
}
            
        
    
                