/**
 * Classe Damier.
 * @author DEMOUGIN Alexandre
 * @author MOR Nicolas
*/

import java.util.Random;
public class Damier{
  /*-----Variable de la classe-----*/

  protected Jeton tab [][];
  private int nbrJeton = 0;
  private int N,M;

  /*-----Constructeur-----*/

  /*-----Méthodes-----*/

  public int getNbrJeton(){return nbrJeton;}
  /**
  * Demande le nombre de Jeton a l'utilisateur.
  */
  public void demandeJeton(){
    boolean test =!((nbrJeton) < (N-3)*(M-3)) && !(nbrJeton > 1);

    Ecran.afficherln("Combien de Jeton voulez-vous ? Le nombre de Jeton maximum est de : " + (N-3)*(M-3) );
    nbrJeton = Clavier.saisirInt();

    while (nbrJeton > ((N-3)*(M-3)) || nbrJeton < 2){
      Ecran.afficher("\n");
      Ecran.afficherln("Erreur de saisie !");
      Ecran.afficherln("Combien de Jeton voulez-vous ? Le nombre de Jeton maximum est de : " + (N-3)*(M-3) );
      nbrJeton = Clavier.saisirInt();
    }
  }
  /**
  * Demande la taille N et M a l'utilisateur.
  */
  public void demandeTaille(){
   do{
      Ecran.afficherln("Combien de colonne(s) voulez-vous ?");
      N = Clavier.saisirInt();
      N +=1;
    } while(N < 3);

    do{
      Ecran.afficherln("Combien de ligne(s) voulez-vous ?");
      M = Clavier.saisirInt();
      M +=1;
    } while(M < 3);
    tab = new Jeton [N][M];
  }
  /**
  * Permet de déplacer le Jeton.
  */
  public void deplacementJeton(){
    int dirx = 0, diry = 0;

    for (int i = 0 ; i < N-1 ; i ++){

      for (int j = 0 ; j < M-1 ; j++){

        if (tab[i][j].getCaractere() == "@ " && tab[i][j].getDepla() == false){
          dirx = tab[i][j].getDirx();
          diry = tab[i][j].getDiry();

          if (tab[i+dirx][j+diry].getCaractere() == "@ " ){
            tab[i][j].detruit();
          }

          if (tab[i+dirx][j+diry].getCaractere() == "* " ){
            tab[i][j].directionJeton();
          }

          if (tab[i+dirx][j+diry].getCaractere() == "  " ){
            Jeton.deviens(tab[i][j], tab[i+dirx][j+diry]);
          }
        }
      }
    }
    resetDepla();
  }
  /**
  * Permet de deplacer le Jeton grace a une graine.
  * @param rnd Graine
  */
  public void deplacementJetonV2(Random rnd){
    int dirx = 0, diry = 0;

    for (int i = 0 ; i < N-1 ; i ++){

      for (int j = 0 ; j < M-1 ; j++){

        if (tab[i][j].getCaractere() == "@ " && tab[i][j].getDepla() == false){
          dirx = tab[i][j].getDirx();
          diry = tab[i][j].getDiry();

          if (tab[i+dirx][j+diry].getCaractere() == "@ " ){
            tab[i][j].detruit();
          }

          if (tab[i+dirx][j+diry].getCaractere() == "* " ){
            tab[i][j].directionJetonV2(rnd);
          }

          if (tab[i+dirx][j+diry].getCaractere() == "  " ){
            Jeton.deviens(tab[i][j], tab[i+dirx][j+diry]);
          }
        }
      }
    }
    resetDepla();
  }
  /**
  * Permet d'initialiser le tableau.
  */
  public void initTab(){

    for (int i = 0; i < N ; i++){

      for (int j = 0; j < M ; j++){

        if (i == 0 || j == 0 || i == N-2 || j == M-2){
          tab[i][j] = new Jeton(2);
        }

        else {
          tab[i][j] = new Jeton(1);
        }
      }
    }
  }
  /**
  * Permet de remettre a zero la variable de déplacement.
  */
  public void resetDepla(){

    for(int i = 0 ; i < N-1 ; i++){

      for (int j = 0; j < M-1; j++){

        if (tab[i][j].getDepla()){
          tab[i][j].setDepla(false);
        }
      }
    }
  }
  /**
  * Permet l'affichage du Damier.
  * @param a entier permettant de differencier la méthode toString.
  */
  public void toString(int a){

    for (int i = 0; i < N-1 ; i++){

      for (int j = 0; j < M-1 ; j++){
        Ecran.afficher(tab[i][j].getCaractere());
      }
    Ecran.afficherln("");
    }
  }
}
