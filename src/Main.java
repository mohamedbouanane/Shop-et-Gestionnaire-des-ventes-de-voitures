import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Main
 * */
public class Main {
  private static BufferedReader consoleReader;

  /**
   * Main
   * */
  public static void main(String[] args) throws Exception {
    consoleReader = new BufferedReader(new InputStreamReader(System.in));
    afficherMenuPrincipal();
  }

  /**
   * Afficher l'interface Menu principal sur console
   * @throws IOException
   * */
  public static void afficherMenuPrincipal() throws IOException {
    Boolean retourPrecedentInterface = false;
    while (true) {
      viderConsole();
      System.out.println(
        "Menu principal >\n\n" +
        "1 - Compte client\n" +
        "2 - Compte concessionaire\n" +
        "3 - Quitter\n" +
        "Veuillez sélectionner votre choix :"
      );

      String saisie = consoleReader.readLine();
      switch (saisie) {
        case "1":
          afficherAccueilClient();
          break;
        case "2":
          afficherAccueilConcessionaire();
          break;
        case "3":
          System.exit(0);
          break;
      }
    }
  }

  // ------------------------------------------ Interfaces Concessionaire ------------------------------------------

  /**
   *  Afficher l'interface Authentification sur console
   * (l'accès à cette interface est protégé par authentification)
   * @throws IOException
   * */
  public static void afficherAccueilConcessionaire() throws IOException {
    Boolean authentificationCorrecte = verrifierAuthentification();
    if (authentificationCorrecte == true) while (true) {
      viderConsole();
      System.out.println(
        "Menu principal > Accueil Concessionaire >\n\n" +
        "1 - Bilan du magasin\n" +
        "2 - La liste des demandes d'achat de véhicules\n" +
        "3 - Gérer les véhicules\n" +
        "Veuillez sélectionner le type d'interface que vous voulez y accéder :"
      );

      String saisie = consoleReader.readLine();
      switch (saisie) {
        case "1":
          afficherAccueilClient();
          break;
        case "2":
          afficherAccueilConcessionaire();
          break;
        case "3":
          System.exit(0);
          break;
      }
    }
  }

  /**
   *  Afficher l'interface Authentification sur console
   * (L'utilisateur s'authentifie en insérant son identifiant et son mot de passe.
   * un champs vide sur username lance un retour vers l'interface Menu principal).
   * @throws IOException
   * */
  public static Boolean verrifierAuthentification() throws IOException {
    String username = "";
    String motDePasse = "";
    while (true) {
      viderConsole();
      System.out.println(
        "Menu principal > Authentification >\n\n" +
        "Entrez votre nom d'utilisateur (vide = quitter l'application):"
      );
      username = consoleReader.readLine();

      // Rechercher l'utilisateur en question et définir son type

      if (username != "") {
        System.out.println("Entrer le mot de passe");
        motDePasse = consoleReader.readLine();
        // verrification de l'authentification

        return true;
      } else System.exit(0);
    }
  }

  // ------------------------------------------ Interfaces Client ------------------------------------------

  /**
   *  Afficher l'interface acceuil client sur console
   * @throws IOException
   * */
  public static void afficherAccueilClient() throws IOException {
    Boolean authentificationCorrecte = verrifierAuthentification();
    if (authentificationCorrecte == true) while (true) {
      viderConsole();
      System.out.println(
        "Introducation sur l'application\n\n" +
        "1 - Passer une demande d'achat d'un véhicule\n" +
        "2 - Mes commandes" +
        "3 - Menu principal\n" +
        "Veuillez sélectionner le type d'interface que vous voulez y accéder :"
      );

      String saisie = consoleReader.readLine();
      switch (saisie) {
        case "1":
          afficherAccueilClient();
          break;
        case "2":
          afficherAccueilConcessionaire();
          break;
        case "3":
          System.exit(0);
          break;
      }
    }
  }

  /**
   *  Afficher l'interface des véhicules disponible en vante sur console
   * @throws IOException
   * */
  public static void afficherShopeVehicules() throws IOException {}

  /**
   *  Afficher l'interface Authentification sur console
   * @throws IOException
   * */
  public static void afficherVéhiculesEnVante() throws IOException {}

  /**
   * Vider le contenue de la console
   * @throws IOException
   * */
  public static void viderConsole() throws IOException {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
