/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_vanmullem_larnac;

/**
 *
 * @author Soso
 */
public class CelluleDeGrille {
    private Jeton jetonCourant;
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;
    
    CelluleDeGrille(Jeton cellule, boolean tn, boolean des) {
        cellule = null;
        tn = false;
        des = false;
    }
    boolean PresenceJeton(boolean cellule){
        if (cellule==null){
            return true;
        }else{
            return false;
        }
        
    }
}
