import classes.AbstractUtilisateur;
import classes.AbstractVehicule;
import classes.Acheteur;
import classes.Concessionaire;
import classes.FormulaireAchatVehicule;
import classes.InterfaceMagasin;
import classes.Magasin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;
import testes.DataTests;

// javac Main.java
// java Main

/**
 * Class Main
 */
public class Main {
  private static BufferedReader consoleReader;
  private static InterfaceMagasin magasin;

  public static void main(String[] args) throws Exception {
    consoleReader = new BufferedReader(new InputStreamReader(System.in));
    magasin = Magasin.getInstance();
    DataTests dataTests = new DataTests();
    dataTests.insertionsDonneesTeste(); // !!!!!!! Enlever cette ligne une fois les testes integre avec JUNIT !!!!!!!

    afficherMenuPrincipal();
  }

  // ________________________ Debut interface menu principal

  // Done
  /**
   *  Afficher l'interface Menu Principal sur console
   *  @throws IOException
   */
  private static void afficherMenuPrincipal() {
    String saisie = "";

    try {
      while (true) {
        viderConsole();
        print("Menu principal >\n");
        print(
          "Bienvenue au magasin [ " +
          magasin.getNomMagasin() +
          " ]\n\n" +
          "Fonctionnalites de l'application:\n" +
          "- Verification d'acces utilisateur.\n" +
          "- Gestion du magasin et la mise en vente des vehicules.\n" +
          "- Gestion de la prise de commande pour les utilisateurs acheteurs.\n" +
          "- Persisstance des donnees en locale sous forme d'un fichier.\n\n" +
          "1 - Connexion\n" +
          "2 - Quitter\n\n" +
          "Entrez un choix :"
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

  // Done
  /**
   *  Afficher l'interface Authentification sur console
   * - L'utilisateur s'authentifie en inserant son identifiant et son mot de passe.
   * - Redirection vers l'interface destination en fonction du type d'utilisateur identifie (Accueil Concessionaire | Accueil Client ).
   * - Champs vide sur username = fermeture de l'application.
   * @throws IOException
   */
  private static void afficherAuthentification() throws IOException {
    String identifiant = "";
    String motDePasse = "";

    while (true) {
      viderConsole();
      print("Menu principal > Authentification >\n");

      // Afficher tout les utilisateurs existant
      print(
        "Liste des utilisateurs enregistre (" +
        magasin.getCollectionUtilisateurs().size() +
        ")"
      );
      printDelimiter();
      print("Type utilisateur \tIdentifiant\t\tMot de passe\n");
      for (AbstractUtilisateur utilisateur : magasin
        .getCollectionUtilisateurs()
        .values()) {
        print(
          utilisateur.getClass().getSimpleName() + // Retourne le type de la classe
          "\t\t" +
          utilisateur.toString()
        );
      }
      printDelimiter();
      // saisie du nom d'utilisateur
      print(
        "\nEntrez votre identifiant d'utilisateur (vide = retour au menu principal):"
      );
      identifiant = consoleReader.readLine();
      // retour au menue principale si le nom d'utilisateur est vide
      if (identifiant.equals("") || identifiant.isEmpty()) {
        break; // Sortir de la boucle while (true)
      }

      // saisie du mot de passe
      print("Entrez le mot de passe:");
      motDePasse = consoleReader.readLine();

      // verrification de l'authentification et redirection en fonction du type d'utilisateur identifie
      for (AbstractUtilisateur utilisateur : magasin
        .getCollectionUtilisateurs()
        .values()) {
        if (
          utilisateur.getIdentifiant().equals(identifiant) &&
          utilisateur.getMotDePasse().equals(motDePasse)
        ) {
          // Enregistrer l'utilisateur en cours
          magasin.setUtilisateurEnCours(utilisateur);

          if (
            utilisateur
              .getClass()
              .getSimpleName()
              .equals(Concessionaire.class.getSimpleName())
          ) {
            afficherAccueilConcessionaire();
          } else {
            afficherAccueilClient();
          }
          break; // Sortir de la boucle while (true)
        }
      }
    }
  }

  // ________________________ Fin interface authentification

  // ________________________ Debut interfaces concessionaire

  // Done
  /**
   * Afficher l'interface Authentification sur console
   * (l'accès à cette interface est protege par authentification)
   * @throws IOException
   */
  private static void afficherAccueilConcessionaire() throws IOException {
    String saisie = "";
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();
      print("Menu principal > Authentification > Accueil Concessionaire >\n");
      print(
        "Utilisateur: " +
        magasin.getUtilisateurEnCours().getIdentifiant() +
        "\n"
      );
      print(
        "1 - Bilan du magasin\n" +
        "2 - Gerer les demandes d'achat de vehicules\n" +
        "3 - Mes vehicules\n" +
        "4 - Se deconnecter\n\n" +
        "Entrez un choix :"
      );

      saisie = consoleReader.readLine();
      switch (saisie) {
        case "1":
          afficherBilanMagasin();
          break;
        case "2":
          afficherGestionDemandesAchatVehicules();
          break;
        case "3":
          afficherMesVehicules();
          break;
        case "4":
          retourner = true;
          break;
      }
    }
  }

  // Done
  /**
   * Afficher l'interface Bilan Magasin sur console
   * @throws IOException
   */
  private static void afficherBilanMagasin() throws IOException {
    viderConsole();
    print(
      "Menu principal > Authentification > Accueil Concessionaire > Bilan Magasin >\n"
    );
    print(
      "Utilisateur: " + magasin.getUtilisateurEnCours().getIdentifiant() + "\n"
    );
    print("Tableau de bord du magasin:");
    printDelimiter();
    print(magasin.toString());
    printDelimiter();
    print("\nAppuyez sur une touche pour retourner :");
    consoleReader.read();
  }

  // Done
  /**
   * Afficher l'interface gestion des demandes d'achat de vehicules sur console
   * @throws IOException
   */
  private static void afficherGestionDemandesAchatVehicules()
    throws IOException {
    String saisie = "";
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();

      // affichage de la liste des formulaires des demande d'achat de vehicules non confirme
      print(
        "Menu principal > Authentification > Accueil Concessionaire > Gestion des demandes d'achat de vehicules >\n"
      );
      print(
        "Utilisateur: " +
        magasin.getUtilisateurEnCours().getIdentifiant() +
        "\n"
      );
      print("Lites des commandes:");
      printDelimiter();
      print(
        "Numero\t" +
        "Date de la commande\t\t" +
        "Nom acheteur\t" +
        "Contact\t\t" +
        "Voiture\n"
      );
      for (Map.Entry<Long, FormulaireAchatVehicule> formulaire : magasin
        .getCollectionFormulaireAchatVehicules()
        .entrySet()) {
        if (formulaire.getValue().getIsAchatFinalise() == false) {
          print(
            formulaire.getKey().toString() +
            "\t" +
            formulaire.getValue().toString()
          );
        }
      }
      printDelimiter();

      // validation d'achat
      while (true) {
        print(
          "\nSelectionner le numero de la demande à fonalisé (vide = retour vers l'accueil):"
        );
        saisie = consoleReader.readLine();

        // Si la saisie est vide -> retour vers Accueil Concessionaire
        if (saisie.equals("") || saisie.isEmpty()) {
          retourner = true; // Sortir de la boucle while (retourner != true)
          break; // Sortir de la boucle while (true)
        } else {
          // Cotrole de la saisie -> l'entree doit être un chiffre et doit faire partie des cles de la collection
          try {
            Long key = Long.parseLong(saisie);
            FormulaireAchatVehicule formulaire = magasin
              .getCollectionFormulaireAchatVehicules()
              .get(key);

            if (formulaire != null) {
              print(
                "\nVous confirmer la cloture de l'achat ? o(oui) / n(non):"
              );
              saisie = consoleReader.readLine().toLowerCase();

              if (saisie.equals("o") || saisie.equals("oui")) {
                formulaire.setIsAchatFinalise(true);
                break; // Sortir de la boucle while (true)
              } else if (saisie.equals("n") || saisie.equals("non")) {
                break; // Sortir de la boucle while (true)
              }
              print("\nSaisie incorrecte!");
            }
          } catch (Exception e) {}
        }
      }
    }
  }

  // Done
  private static void afficherMesVehicules() throws IOException {
    String saisie = "";
    Boolean retourner = false;
    Boolean vendue = false;

    while (retourner != true) {
      viderConsole();

      print(
        "Menu principal > Authentification > Accueil Concessionaire > Mes vehicules >\n"
      );
      print(
        "Utilisateur: " +
        magasin.getUtilisateurEnCours().getIdentifiant() +
        "\n"
      );
      print("Lites des commandes:");
      printDelimiter();

      // Affiche la liste de véhicules
      print(
        "Numero\t" +
        "Vehicule\t" +
        "Carburant\t" +
        "Prix d'achat(£)\t" +
        "Prix de vente(£)\t" +
        "Fournisseur\t" +
        "Vendue"
      );

      for (Map.Entry<Long, AbstractVehicule> vehicule : magasin
        .getCollectionVehicules()
        .entrySet()) {
        // Verrifier si le véhicule à était vendue ou non
        vendue = false;
        for (FormulaireAchatVehicule formulaire : magasin
          .getCollectionFormulaireAchatVehicules()
          .values()) {
          if (
            vehicule.getValue().getImmatriculation() ==
            formulaire.getVehicule().getImmatriculation()
          ) {
            vendue = true;
            break;
          }
        }
        print(
          vehicule.getKey().toString() +
          "\t" +
          vehicule.getValue().getNom() +
          "\t" +
          vehicule.getValue().getCarburant() +
          "\t\t" +
          vehicule.getValue().getPrixAchat() +
          "\t\t" +
          vehicule.getValue().getPrixVente() +
          "\t" +
          vehicule.getValue().getFournisseur() +
          "\t" +
          vendue
        );
      }
      printDelimiter();

      // supression d'un véhicule

      print(
        "\nSelectionner le numero de véhicule à supprimer (vide = retour vers l'accueil):"
      );
      saisie = consoleReader.readLine();

      // Si la saisie est vide -> retour vers Accueil Concessionaire
      if (saisie.equals("") || saisie.isEmpty()) {
        retourner = true; // Sortir de la boucle while (retourner != true)
        break; // Sortir de la boucle while (true)
      } else {
        // Cotrole de la saisie -> l'entree doit être un chiffre et doit faire partie des cles de la collection
        while (true) {
          try {
            Long key = Long.parseLong(saisie);

            print(
              "\nVous confirmer la supression du véhicule ? o(oui) / n(non):"
            );
            saisie = consoleReader.readLine().toLowerCase();

            if (saisie.equals("o") || saisie.equals("oui")) {
              magasin.supprimerVehicule(key);
              break; // Sortir de la boucle while (true)
            } else if (saisie.equals("n") || saisie.equals("non")) {
              break; // Sortir de la boucle while (true)
            }
            print("\nSaisie incorrecte!");
          } catch (Exception e) {}
        }
      }
    }
  }

  // ________________________ Fin interfaces concessionaire

  // ________________________ Debut interfaces client/acheteur

  // Done
  /**
   * Afficher l'interface acceuil client sur console
   * @throws IOException
   */
  private static void afficherAccueilClient() throws IOException {
    String saisie = "";
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();
      print("Menu principal > Authentification > Accueil Client >\n");
      print(
        "Utilisateur: " +
        magasin.getUtilisateurEnCours().getIdentifiant() +
        "\n"
      );
      print(
        "1 - Passer une commande d'achat d'un vehicule\n" +
        "2 - Mes commandes\n" +
        "3 - Se deconnecter\n\n" +
        "Entrez un choix :"
      );

      saisie = consoleReader.readLine();
      switch (saisie) {
        case "1":
          afficherShopeVehicules();
          break;
        case "2":
          afficherGererMesCommandes();
          break;
        case "3":
          retourner = true;
          break;
      }
    }
  }

  // Done
  /**
   * Afficher l'interface des vehicules disponible en vante sur console
   * @throws IOException
   */
  private static void afficherShopeVehicules() throws IOException {
    String saisie = "";
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();
      print(
        "Menu principal > Authentification > Accueil Client > Shope Vehicules >\n"
      );
      print(
        "Utilisateur: " +
        magasin.getUtilisateurEnCours().getIdentifiant() +
        "\n"
      );

      // Afficher les voitures pas encor vendue
      print("Liste des véhicules diponible:");
      printDelimiter();
      print("Num\t" + "Vehicule\t\t" + "Prix de vente(£)");
      for (Map.Entry<Long, AbstractVehicule> vehicule : magasin
        .getVoituresEnVente()
        .entrySet()) {
        print(
          vehicule.getKey().toString() +
          "\t" +
          vehicule.getValue().getMarque() +
          " " +
          vehicule.getValue().getNom() +
          "\t" +
          vehicule.getValue().getPrixVente() +
          "\n"
        );
      }
      printDelimiter();
      // validation de la commande
      while (true) {
        print(
          "\nSelectionner le numero du vehicule que vous voulez commander (vide = retour vers l'accueil):"
        );
        saisie = consoleReader.readLine();

        // Si la saisie est vide -> retour vers Accueil Acheteur
        if (saisie.equals("") || saisie.isEmpty()) {
          retourner = true; // Sortir de la boucle while (true)
          break;
        } else {
          // Cotrole de la saisie -> l'entree doit être un chiffre et doit faire partie des cles de la collection
          try {
            Long key = Long.parseLong(saisie);
            AbstractVehicule vehicule = magasin
              .getCollectionVehicules()
              .get(key);

            if (vehicule != null) {
              print("\nVous confirmer la commande ? o(oui) / n(non):");
              saisie = consoleReader.readLine().toLowerCase();

              if (saisie.equals("o") || saisie.equals("oui")) {
                // Enregistrer la commande
                Date now = new Date(); // Date de l'enregistrement

                FormulaireAchatVehicule formulaire = new FormulaireAchatVehicule(
                  vehicule,
                  (Acheteur) magasin.getUtilisateurEnCours(),
                  now
                );
                magasin.ajouterDemandeAchat(formulaire);
                break; // Sortir de la boucle while (true)
              } else if (saisie.equals("n") || saisie.equals("non")) {
                break; // Sortir de la boucle while (true)
              }
              print("\nSaisie incorrecte!");
            }
          } catch (Exception e) {}
        }
      }
    }
  }

  // Done
  /**
   * Afficher gestion des commandes du client connecte
   * @throws IOException
   */
  private static void afficherGererMesCommandes() throws IOException {
    String saisie = "";
    Boolean retourner = false;

    while (retourner != true) {
      viderConsole();
      print(
        "Menu principal > Authentification > Accueil Client > Mes Commandes >\n"
      );
      print(
        "Utilisateur: " +
        magasin.getUtilisateurEnCours().getIdentifiant() +
        "\n"
      );

      // Afficher tout les commandes effectuer par l'utilisateur (acheteur) en cours

      print("Liste de mes commandes:");
      printDelimiter();
      print(
        "Num\t" + "Date de la commande\t\t" + "Vehicule\t\t" + "Prix (£)\n"
      );
      for (Map.Entry<Long, FormulaireAchatVehicule> formulaire : magasin
        .getFormulairesCommandesAcheteur(
          (Acheteur) magasin.getUtilisateurEnCours()
        )
        .entrySet()) {
        print(
          formulaire.getKey().toString() +
          "\t" +
          formulaire.getValue().getDateCommande() +
          "\t" +
          formulaire.getValue().getVehicule().getMarque() +
          " " +
          formulaire.getValue().getVehicule().getNom() +
          "\t" +
          formulaire.getValue().getVehicule().getPrixVente()
        );
      }
      printDelimiter();

      while (true) {
        print(
          "\nSelectionner le numero de la commande que vous voulez annuler (vide = retour vers l'accueil):"
        );
        saisie = consoleReader.readLine();

        // Si la saisie est vide -> retour vers Accueil Acheteur
        if (saisie.equals("") || saisie.isEmpty()) {
          retourner = true; // Sortir de la boucle while (true)
          break;
        } else {
          // Cotrole de la saisie -> l'entree doit être un chiffre et doit faire partie des cles de la collection
          try {
            Long key = Long.parseLong(saisie);
            AbstractVehicule vehicule = magasin
              .getCollectionVehicules()
              .get(key);

            if (vehicule != null) {
              print(
                "\nVous confirmer l'annulation de la commande ? o(oui) / n(non):"
              );
              saisie = consoleReader.readLine().toLowerCase();

              if (saisie.equals("o") || saisie.equals("oui")) {
                magasin.getCollectionFormulaireAchatVehicules().remove(key);
                break; // Sortir de la boucle while (true)
              } else if (saisie.equals("n") || saisie.equals("non")) {
                break; // Sortir de la boucle while (true)
              }
              print("\nSaisie incorrecte!");
            }
          } catch (Exception e) {}
        }
      }
    }
  }

  // ________________________ Fin interfaces client

  // ________________________ Debut methodes complementaires

  // Done
  /**
   * Vider le contenue de la console
   * @throws IOException
   */
  private static void viderConsole() throws IOException {
    try {
      String operatingSystem = System.getProperty("os.name"); //Check the current operating system

      if (operatingSystem.contains("Windows")) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      } else {
        ProcessBuilder pb = new ProcessBuilder("clear");
        Process startProcess = pb.inheritIO().start();

        startProcess.waitFor();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  // Done
  /**
   * Fermer l'application
   */
  private static void quitter() {
    System.exit(0);
  }

  // Done
  private static void print(String text) {
    System.out.println(text);
  }

  // Done
  /**
   * Affichier un délimiteur sur la console
   */
  private static void printDelimiter() {
    System.out.print(
      "________________________________________________________________________\n\n"
    );
  }
  // ________________________ Fin methodes complementaires

}
