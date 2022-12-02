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

public void tasserColonne(int a){
    
}
public boolean colonneRemplie(int b){
    
        return false;
    
}
public boolean presenceTrouNoir(int x, int y ){
    
        return false;
    
} 
public void placerTrouNoir(int x, int y){
    
}
public void supprimerTrouNoir(int x, int y ){
    
} 
public void placerDesintegrateur(int x,int y){
    
}
public void supprimerDesintegrateur(int x,int y){
    
}
public boolean presenceDesintegrateur (int x, int y){
    
        return false;
}
public void supprimerJeton(int x, int y){
    
}
public void recupererJeton(int x, int y){
    
}
}