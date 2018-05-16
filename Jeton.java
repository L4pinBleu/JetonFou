/**
 * Classe Jeton.
 * @author DEMOUGIN Alexandre
 * @author MOR Nicolas
*/

import java.util.Random;

public class Jeton {
  /*-----Déclaration des variables de la classe-----*/

  private String caractere;
  public static int jeton = 0;
  private int dirx = 0;
  private int diry = 0;
  private boolean depla = false;


  /*-----Constructeur-----*/

  //Le Jeton est mobile.
  Jeton (){
    jeton+=1;
    caractere = "@ " ;
    directionJeton();
  }

  //Le Jeton est mobile (avec graine).
  Jeton (Random rnd){
    jeton=jeton+1;
    caractere = "@ " ;
    directionJetonV2(rnd);
  }

  //Le Jeton est vide.
  Jeton(int a){
    if (a == 1){caractere = "  ";}
    if (a == 2){caractere = "* ";}
  }//Case vide

  /*-----Méthodes-----*/

  //Méthodes Setter/Getter

  protected String getCaractere(){return caractere;}
  protected int getDirx(){return dirx;}
  protected int getDiry(){return diry;}
  protected boolean getDepla(){return depla;}
  protected void setDepla(boolean depla){this.depla = depla;}

  //Autres Méthodes

  /**
   * Permet de réinitialiser un Jeton à l'états de "vide".
  */
  private void change(){
    caractere = "  ";
    depla = false;
    dirx = 0;
    diry = 0;
  }
  /**
   * Permet de choisir aléatoirement une direction au Jeton.
  */
  public void directionJeton(){
      int a = (int)(Math.random()*(8));
      switch (a){

        case 0 :
          dirx = 0;
          diry = 1;
          break;

        case 1 :
          dirx = 1;
          diry = 1;
          break;

        case 2 :
          dirx = 1;
          diry = 0;
          break;

        case 3 :
          dirx = 1;
          diry = -1;
          break;

        case 4 :
          dirx = 0;
          diry = -1;
          break;

        case 5 :
          dirx = -1;
          diry = -1;
          break;

        case 6 :
          dirx = -1;
          diry = 0;
          break;

        case 7 :
          dirx = -1;
          diry = 1;
          break;
    }
  }
  /**
   * Permet de choisir aléatoirement une direction au Jeton à partir d'un graine.
  */
  public void directionJetonV2(Random rnd){
      int a = rnd.nextInt(8);
      switch (a){

        case 0 :
          dirx = 0;
          diry = 1;
          break;

        case 1 :
          dirx = 1;
          diry = 1;
          break;

        case 2 :
          dirx = 1;
          diry = 0;
          break;

        case 3 :
          dirx = 1;
          diry = -1;
          break;

        case 4 :
          dirx = 0;
          diry = -1;
          break;

        case 5 :
          dirx = -1;
          diry = -1;
          break;

        case 6 :
          dirx = -1;
          diry = 0;
          break;

        case 7 :
          dirx = -1;
          diry = 1;
          break;
    }
  }
  /**
   * Retire 1 au compteur de Jeton est réinitialise le Jeton.
  */
  public void detruit(){
    jeton = jeton - 1;
    change();
  }
  /**
   * Permet de déplacer un Jeton.
  */
  public static void deviens(Jeton a, Jeton b){
    a.depla = true;

    b.depla = a.depla ;
    b.caractere = a.caractere;
    b.dirx = a.dirx;
    b.diry = a.diry;
    a.change();
  }
  /**
   * Permet de placer aléatoirement un Jeton.
  */
  public static void placeJeton(Jeton tab[][]){
    int x,y;
    do {
      x = (int)(Math.random()*(tab.length-3)+1);
      y = (int)(Math.random()*(tab[0].length-3)+1);
    } while(tab[x][y].caractere == ("* ") || tab[x][y].caractere == ("@ "));
    tab[x][y] = new Jeton();
  }
  /**
   * Permet de placer aléatoirement un Jeton à partir d'un graine.
  */
  public static void placeJetonV2(Jeton tab[][], Random rnd){
    int x,y;
    do {
      x = rnd.nextInt(tab.length-2);
      y = rnd.nextInt(tab[0].length-2);
    } while(tab[x][y].caractere == ("* ") || tab[x][y].caractere == ("@ "));
    tab[x][y] = new Jeton(rnd);
  }


}
