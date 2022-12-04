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
    
    public void CelluleDeGrille() {
        jetonCourant=null;
        avoirTrouNoir = false;
        avoirDesintegrateur =false;
    }
    
    public boolean presenceJeton(){
        if (jetonCourant!=null){
            return true;
        }else{
            return false;
        }    
    }
    
    public void affecterJeton(Jeton jetonCourant) { //permet de prendre un 
        //nouveau jeton et de l'ajouter à ceux déjà existant
        this.jetonCourant = jetonCourant;
    }
    public String LireCouleurDuJeton(){
        if (jetonCourant!=null){
            return jetonCourant.lireCouleur();
        }else{
            return "vide";
        }
    }

    public void placerTrouNoir(){
        avoirTrouNoir = true;
}
    public void supprimerTrouNoir(){
        avoirTrouNoir = false;
}
    public boolean presenceTrouNoir() {
        return avoirTrouNoir;
    }
    
    public Jeton recupererJeton(){
        Jeton jetonTemporaire;
        jetonTemporaire = jetonCourant;
        jetonCourant = null;
        return jetonTemporaire;
    }
    
    public void supprimerJeton(){
        jetonCourant = null;
    }
    public boolean presenceDesintegrateur(){
        if (avoirDesintegrateur == true){
            return true;
        }else{
            return false;           
        }
    }
    public void placerDesintegrateur(){
        avoirDesintegrateur = true;
    }
    public void supprimerDesintegrateur (){
        avoirDesintegrateur = false;
    }
    
    public void activerTrouNoir(){
        supprimerJeton();
        supprimerTrouNoir();    
    }
    
    @Override
    public String toString() {
        if (jetonCourant != null){
            return jetonCourant.toString();
        }
        if (avoirTrouNoir == true) {
            System.out.println("@");
        }
        if (avoirDesintegrateur == true){
            System.out.println("D");
        }
        
        if (avoirDesintegrateur == false & avoirTrouNoir == false & jetonCourant == null){
            System.out.println(".");
        }
        return toString();
    }
}
    
    

