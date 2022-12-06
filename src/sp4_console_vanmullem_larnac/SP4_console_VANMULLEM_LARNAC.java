/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_vanmullem_larnac;

/**
 *
 * @author Anaëlle
 */
public class SP4_console_VANMULLEM_LARNAC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jeton rouge = new Jeton ("rouge");
        Jeton jaune = new Jeton ("jaune");
        System.out.println(rouge);
        System.out.println(jaune);
        String joueurb=null;
        String joueura = null;
        System.out.println("la partie commence");
        joueur joueur1 = new joueur(joueura,0);
        joueur joueur2 = new joueur(joueurb,0);

        Partie une_partie =new Partie(joueur1,joueur2);
        une_partie.lancerPartie();
    }
    
}
