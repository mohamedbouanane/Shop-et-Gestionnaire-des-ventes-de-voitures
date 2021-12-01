import classes.AbstractUtilisateur;
import classes.AbstractVehicule;
import classes.Acheteur;
import classes.Concessionaire;
import classes.FormulaireAchatVehicule;
import classes.Magasin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

// TODO : add Bonjour + nom utilisateur avant chaque interface
/**
 * Class Main
 * */
public class Main {
  private static BufferedReader consoleReader;

  public static void main(String[] args) throws Exception {
    consoleReader = new BufferedReader(new InputStreamReader(System.in));
    //afficherMenuPrincipal();
    afficherAccueilConcessionaire();
    //afficherBilanMagasin();
  }

  // ________________________ Debut interface menu principal

  // ✔️
  /**
   *  Afficher l'interface Menu Principal sur console
   * @throws IOException
   * */
  private static void afficherMenuPrincipal() {
    String saisie = "";

    try {
      while (true) {
        viderConsole();
        print(
          "Menu principal >\n\n" +
          "Bienvenue + présentation de l'application ...\n\n" +
          "1 - Connexion\n" +
          "2 - Quitter\n"
        );
        saisie = consoleReader.readLine();
        switch (saisie) {
          case "1":
            afficherAuthentification();
            break;
          case "2":
            quitter();
            break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // ________________________ Fin interface menu principal

  // ________________________ Debut interface authentification

  // ✔️
  /**
   *  Afficher l'interface Authentification sur console
   * - L'utilisateur s'authentifie en insérant son identifiant et son mot de passe.
   * - Redirection vers l'interface destination en fonction du type d'utilisateur identifié (Accueil Concessionaire | Accueil Client ).
   * - Champs vide sur username = fermeture de l'application.
   * @throws IOException
   * */
  private static void afficherAuthentification() throws IOException {
    String identifiant = "";
    String motDePasse = "";
    Magasin magasin = Magasin.getInstance();
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();

      print("Menu principal > Authentification >\n\n");

      // Afficher tout les utilisateurs existant
      print("Liste des utilisateurs enregistré\n");
      print("Type utilisateur \tIdentifiant\tMot de passe\n");
      for (AbstractUtilisateur utilisateur : magasin
        .getCollectionUtilisateurs()
        .values()) {
        print(
          utilisateur.getClass() +
          "\t" +
          utilisateur.getIdentifiant() +
          "\t" +
          utilisateur.getMotDePasse()
        );
      }

      // saisie du nom d'utilisateur
      print(
        "\n\nEntrez votre nom d'utilisateur (vide = retour au menu principal):"
      );
      identifiant = consoleReader.readLine();

      // retour au menue principale si le nom d'utilisateur est vide
      if (identifiant == "" || identifiant.isEmpty()) {
        break; // Sortir de la boucle while (true)
      }

      // saisie du mot de passe
      print("Entrez le mot de passe:");
      motDePasse = consoleReader.readLine();

      // verrification de l'authentification et redirection en fonction du type d'utilisateur identifié
      for (AbstractUtilisateur utilisateur : magasin
        .getCollectionUtilisateurs()
        .values()) {
        if (
          utilisateur.getIdentifiant() == identifiant &&
          utilisateur.getMotDePasse() == motDePasse
        ) {
          // Enregistrer l'utilisateur en cours
          magasin.setUtilisateurEnCours(utilisateur);
          if (utilisateur.getClass() == Concessionaire.class) {
            afficherAccueilConcessionaire();
          } else {
            afficherAccueilClient();
          }
          retourner = true;
        }
      }
    }
  }

  // ________________________ Fin interface authentification

  // ________________________ Debut interfaces concessionaire

  // ✔️
  /**
   *  Afficher l'interface Authentification sur console
   * (l'accès à cette interface est protégé par authentification)
   * @throws IOException
   * */
  private static void afficherAccueilConcessionaire() throws IOException {
    String saisie = "";
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();
      print(
        "Menu principal > Authentification > Accueil Concessionaire >\n\n" +
        "1 - Bilan du magasin\n" +
        "2 - Gérer les demandes d'achat de véhicules\n" +
        "3 - Gérer les véhicules\n" +
        "4 - Se déconnecter\n\n" +
        "Entrez un choix :"
      );

      saisie = consoleReader.readLine();
      switch (saisie) {
        case "1":
          afficherBilanMagasin();
          break;
        case "2":
          afficherGestionDemandesAchatVéhicules();
          break;
        case "3":
          afficherGestionVehicules();
          break;
        case "4":
          retourner = true;
          break;
      }
    }
  }

  // ✔️
  /**
   * Afficher l'interface Bilan Magasin sur console
   * @throws IOException
   * */
  private static void afficherBilanMagasin() throws IOException {
    Magasin magasin = Magasin.getInstance();

    viderConsole();
    print(
      "Menu principal > Authentification > Accueil Concessionaire > Bilan Magasin >\n"
    );
    print(
      "Nom du magasin:\t" +
      magasin.getNom() +
      "\n- Dépences:\t" +
      magasin.getDepences() +
      "\n- Revenus:\t" +
      magasin.getRevenus() +
      "\n- Benefices:\t" +
      magasin.getBenefices()
    );

    print("\n\nAppuyez sur une touche pour retourner :");
    consoleReader.read();
  }

  // ✔️
  /**
   * Afficher l'interface gestion des demandes d'achat de véhicules sur console
   * @throws IOException
   * */
  private static void afficherGestionDemandesAchatVéhicules()
    throws IOException {
    String saisie = "";
    Magasin magasin = Magasin.getInstance();
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();

      // affichage de la liste des formulaires des demande d'achat de véhicules non confirmé
      print(
        "Menu principal > Authentification > Accueil Concessionaire > Gestion des demandes d'achat de véhicules >\n\n"
      );
      print("Numéro\tNom achteur\tContact\tVoiture\n");
      for (Map.Entry<Long, FormulaireAchatVehicule> formulaire : magasin
        .getCollectionFormulaireAchatVehicules()
        .entrySet()) {
        if (formulaire.getValue().getIsAchatFinalise() == false) {
          print(
            formulaire.getKey().toString() +
            "\t" +
            formulaire.getValue().getAcheteur().getNom() +
            " " +
            formulaire.getValue().getAcheteur().getPrenom() +
            "\t" +
            formulaire.getValue().getAcheteur().getTelephone() +
            " " +
            formulaire.getValue().getAcheteur().getEmail() +
            "\t" +
            formulaire.getValue().getVehicule().getNom() +
            " " +
            formulaire.getValue().getVehicule().getMarque() +
            "\n\n"
          );
        }
      }

      // validation d'achat
      while (true) {
        print(
          "\nSéléctionner le numéro de la demande que vous souhaitez confirmer l'achat (vide = retour vers Accueil Concessionaire):"
        );
        saisie = consoleReader.readLine();

        // Si la saisie est vide -> retour vers Accueil Concessionaire
        if (saisie == "" || saisie.isEmpty()) {
          retourner = true; // Sortir de la boucle while (retourner != true)
          break; // Sortir de la boucle while (true)
        } else {
          // Cotrole de la saisie -> l'entreé doit être un chiffre et doit faire partie des clés de la collection
          try {
            Long key = Long.parseLong(saisie);
            FormulaireAchatVehicule formulaire = magasin
              .getCollectionFormulaireAchatVehicules()
              .get(key);

            if (formulaire != null) {
              print("Vous confirmer la cloture de l'achat ? y(yes) / n(non):");
              saisie = consoleReader.readLine().toLowerCase();

              if (saisie == "y" || saisie == "yes") {
                formulaire.setIsAchatFinalise(true);
              }
              break;
            }
          } catch (Exception e) {}
        }
      }
    }
  }

  // ✔️
  /**
   * Afficher l'interface gestion des vehicules sur console
   * @throws IOException
   * */
  private static void afficherGestionVehicules() throws IOException {
    String saisie = "";
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();
      print(
        "Menu principal > Authentification > Accueil Concessionaire > Gestion des véhicules >\n\n" +
        "1 - Afficher tous les véhicules\n" +
        "2 - Ajouter un nouveau véhicule\n" +
        "3 - Retour vers l'accueil\n\n" +
        "Entrez un choix :"
      );

      saisie = consoleReader.readLine();
      switch (saisie) {
        case "1":
          afficherEditerVehicules();
          break;
        case "2":
          afficherAjouterVehicules();
          break;
        case "3":
          retourner = true;
          break;
      }
    }
  }

  // TODO build
  private static void afficherEditerVehicules() throws IOException {
    print(
      "Menu principal > Authentification > Accueil Concessionaire > Gestion des véhicules > Editer Véhicules >\n\n"
    );

    print("Vehicule\t" + "Prix de vente\t" + "Prix d'achat\t" + "Fournisseur");
  }

  // TODO build
  private static void afficherAjouterVehicules() throws IOException {
    print(
      "Menu principal > Authentification > Accueil Concessionaire > Gestion des véhicules > Ajouter Véhicules >\n\n"
    );
  }

  // ________________________ Fin interfaces concessionaire

  // ________________________ Debut interfaces client

  // ✔️
  /**
   *  Afficher l'interface acceuil client sur console
   * @throws IOException
   * */
  private static void afficherAccueilClient() throws IOException {
    String saisie = "";
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();
      print(
        "Menu principal > Authentification > Accueil Client >\n\n" +
        "1 - Passer une commande d'achat d'un véhicule\n" +
        "2 - Mes commandes\n" +
        "3 - Se déconnecter\n\n" +
        "Entrez un choix :"
      );

      saisie = consoleReader.readLine();
      switch (saisie) {
        case "1":
          afficherShopeVehicules();
          break;
        case "2":
          afficherMesCommandes();
          break;
        case "3":
          retourner = true;
          break;
      }
    }
  }

  // TODO : Build
  /**
   *  Afficher l'interface des véhicules disponible en vante sur console
   * @throws IOException
   * */
  private static void afficherShopeVehicules() throws IOException {
    String saisie = "";
    Magasin magasin = Magasin.getInstance();

    while (true) {
      viderConsole();
      print(
        "Menu principal > Authentification > Accueil Client > Shope Vehicules\n\n"
      );

      print(
        "Vehicule\t" + "Prix de vente\t" + "Prix d'achat\t" + "Fournisseur"
      );
      // Afficher les voitures pas encor vendue
      for (AbstractVehicule vehicule : magasin.getVoituresEnVente().values()) {
        print(
          vehicule.getNom() +
          " " +
          vehicule.getMarque() +
          "\t" +
          vehicule.getPrixVente()
        );
      }

      print(
        "\nSéléctionner l'identifiant du véhicule que vous voulez commander (vide = retourner vers l'accueil):"
      );

      saisie = consoleReader.readLine();
      if (saisie == "" || saisie.isEmpty()) {
        break; // Sortir de la boucle while (true)
      }
    }
  }

  // TODO build (afficher / annuler commande)
  /**
   *  Afficher les commandes passé par le client en connecté
   * @throws IOException
   * */
  private static void afficherMesCommandes() throws IOException {
    Magasin magasin = Magasin.getInstance();

    // Afficher tout les commandes effectuer par l'achteur en cours
    for (Map.Entry<Long, FormulaireAchatVehicule> formulaire : magasin
      .getFormulairesCommandesAcheteur(
        (Acheteur) magasin.getUtilisateurEnCours()
      )
      .entrySet()) {
      // Continuer
      print("");
    }
  }

  // ________________________ Fin interfaces client

  // ________________________ Debut méthodes complémentaires

  /**
   * Vider le contenue de la console
   * @throws IOException
   * */
  private static void viderConsole() throws IOException {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Fermer l'application
   */
  private static void quitter() {
    System.exit(0);
  }

  private static void print(String text) {
    System.out.println(text);
  }
  // ________________________ Fin méthodes complémentaires

}
