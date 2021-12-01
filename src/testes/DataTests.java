package testes;

import classes.AbstractUtilisateur;
import classes.AbstractVehicule;
import classes.Acheteur;
import classes.Concessionaire;
import classes.Fournisseur;
import classes.Magasin;
import classes.Minibus;
import classes.Suv4x4;

public class DataTests {

  // TODO build

  /**
   * Insertion de données de test
   */
  public static void insertionsDonnéesTeste() {
    Magasin magasin = Magasin.getInstance();

    AbstractUtilisateur concessionaire1;
    AbstractUtilisateur concessionaire2;
    AbstractUtilisateur concessionaire3;

    AbstractUtilisateur acheteur1;
    AbstractUtilisateur acheteur2;
    AbstractUtilisateur acheteur3;

    Fournisseur fournisseur1;
    Fournisseur fournisseur2;
    Fournisseur fournisseur3;
    Fournisseur fournisseur4;
    Fournisseur fournisseur5;
    Fournisseur fournisseur6;

    AbstractVehicule minibus1;
    AbstractVehicule minibus2;
    AbstractVehicule minibus3;

    AbstractVehicule suv4x4_1;
    AbstractVehicule suv4x4_2;
    AbstractVehicule suv4x4_3;

    // Configuration du magasin
    magasin.setNom("Leader Auto");

    // Création d'utilisateurs Concessionaire
    concessionaire1 = new Concessionaire("conc1", "conc1", "DESFSEF");
    concessionaire2 = new Concessionaire("conc2", "conc2", "DESFSEF");
    concessionaire3 = new Concessionaire("conc3", "conc3", "DESFSEF");

    // Création d'utilisateurs Acheteurs
    acheteur1 = new Acheteur();
    acheteur2 = new Acheteur();
    acheteur3 = new Acheteur();

    // Création des fournisseurs
    fournisseur1 = new Fournisseur();
    fournisseur1 = new Fournisseur();
    fournisseur1 = new Fournisseur();
    fournisseur1 = new Fournisseur();
    fournisseur1 = new Fournisseur();
    fournisseur1 = new Fournisseur();

    // Création de véhicules Minibus
    minibus1 = new Minibus();
    minibus2 = new Minibus();
    minibus3 = new Minibus();

    suv4x4_1 = new Suv4x4();
    suv4x4_2 = new Suv4x4();
    suv4x4_3 = new Suv4x4();
  }
}
