/**
 * Classe JetonFou.
 * @author DEMOUGIN Alexandre
 * @author MOR Nicolas
*/

import java.util.Random;
public class JetonFou {
  /**
   * Permet d'initialiser l'affichage graphique.
   * @param cg La FenetreGraphique ou afficher le resultat.
   * @param tab Tableau de Jeton ou les resultats seront obtenu.
  */
  private static void actualisationGraphiqueMur(FenetreGraphique cg, Jeton tab[][]){
    int pix = 10;
    int N = tab.length;
    int M = tab[0].length;
    cg.clear();
    cg.setColor(0,0,0);

    for (int i = 0 ; i < N-1 ; i++){

      for (int j = 0 ; j < M-1 ; j++){

        if (tab[i][j].getCaractere() == "* "){
          cg.fillRect(pix*i,pix*j,10,10);
        }

        if (tab[i][j].getCaractere() == "@ "){
          cg.fillCircle(pix*i+pix/2,pix*j+pix/2,4);
        }
      }
    }
    for (int j = 0 ; j < M; j++){
      cg.drawLine(0,pix*j, (pix*N)-pix, pix*j);
    }

    for (int i = 0 ; i < N ; i++){
      cg.drawLine(pix*i,0, pix*i, (pix*M)-pix);
    }

    cg.flush();
    cg.wait(50);
  }
  /**
   * Exécute la Version1 du programme.
  */
  private static void Version1(){
    Damier a = new Damier();
    a.demandeTaille();
    Jeton.jeton = 0;
    a.demandeJeton();
    a.initTab();

    while (Jeton.jeton != a.getNbrJeton()){
      Jeton.placeJeton(a.tab);
      }
    a.toString(1);

    while (Jeton.jeton > 1){
      a.deplacementJeton();
      a.toString(1);
    }
    Ecran.afficherln("Fin du programme avec nbrJeton en jeu : " + Jeton.jeton);
    a.toString(1);
  }
  /**
   * Exécute la Version2 du programme.
  */
  private static void Version2(){
    Random rnd = new Random();
    Ecran.afficherln("Quel numéro de graine ?");
    rnd.setSeed(Clavier.saisirLong());

    Damier a = new Damier();
    a.demandeTaille();
    Jeton.jeton = 0;
    a.demandeJeton();
    a.initTab();
    while (Jeton.jeton != a.getNbrJeton()){
      Jeton.placeJetonV2(a.tab,rnd);
      }
    a.toString(1);

    while (Jeton.jeton > 1){
      a.deplacementJetonV2(rnd);
      a.toString(1);
    }

    Ecran.afficherln("Fin du programme avec nbrJeton en jeu : " + Jeton.jeton);
    a.toString(1);
    }
  /**
   * Exécute la Version3 du programme.
  */
  private static void Version3(){
    int px = 20,py = 20;
    Damier jeu = new Damier();
    jeu.demandeTaille();
    Jeton.jeton = 0;
    jeu.demandeJeton();
    jeu.initTab();

    while (Jeton.jeton != jeu.getNbrJeton()){
      Jeton.placeJeton(jeu.tab);
      }

    //Fenetre Graphique
    FenetreGraphique cg = new FenetreGraphique(50,50,480,360,1600,900,"Jeton Fou");
    cg.setClearColor(255,255,255);
    // Ordre d'effacement de la zone d'affichage
    cg.clear();
    actualisationGraphiqueMur(cg,jeu.tab);

    while(Jeton.jeton > 1){
      jeu.deplacementJeton();
      actualisationGraphiqueMur(cg,jeu.tab);
    }

    cg.setColor(200,200,50);
    cg.wait(3000);
    cg.exit();
  }

  public static void main(String[] args) {
    String user;
    boolean a = true;

    while (a){
      Ecran.afficher("\n");
      Ecran.afficherln("Bienvenu dans le programme JetonFou ! Quelle version voulez-vous ?");
      Ecran.afficherln("Tapez /v1 pour la Version1.\n" +
      "Tapez /v2 pour la version 2. \n" +
      "Tapez /v3 pour la version 3. \n" +
      "Tapez /q pour quitter le programme.");
      user = Clavier.saisirString();

      switch (user){

        case "/v1" :
          Version1();
          break;

        case "/v2" :
          Version2();
          break;

        case "/v3" :
          Version3();
          break;

        case "/q" :
          Ecran.afficherln("*--- Au revoir ! ---*");
          System.exit(1);
          break;

        default :
          Ecran.afficher("\n\n");
          Ecran.afficherln("\tERREUR DE SAISIE !");
          break;
        }
    }
  }
}
