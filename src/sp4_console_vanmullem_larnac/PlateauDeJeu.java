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
}

            
        
    
                
