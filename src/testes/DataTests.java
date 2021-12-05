package testes;

import classes.AbstractUtilisateur;
import classes.AbstractVehicule;
import classes.Acheteur;
import classes.Concessionaire;
import classes.EnumCarburant;
import classes.FormulaireAchatVehicule;
import classes.Fournisseur;
import classes.InterfaceMagasin;
import classes.Magasin;
import classes.Minibus;
import classes.Suv4x4;
import java.util.Date;

/**
 * Donnees de teste
 */
public class DataTests {
  private InterfaceMagasin magasin;

  // Done
  /**
   * Insertion de donnees de test
   */
  public void insertionsDonneesTeste() {
    // Initalisation des classes
    magasin = Magasin.getInstance();

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

    FormulaireAchatVehicule formulaire1;
    FormulaireAchatVehicule formulaire2;
    FormulaireAchatVehicule formulaire3;
    FormulaireAchatVehicule formulaire4;

    // Instanciation des classes

    // Creation d'utilisateurs Concessionaire
    concessionaire1 =
      new Concessionaire("zo@toze.jp", "pass1", "Ollie Daniels");
    concessionaire2 =
      new Concessionaire("ef@wufwezu.ck", "pass2", "Ida Lambert");
    concessionaire3 =
      new Concessionaire("lahkeh@reeb.au", "pass3", "Minerva Wise");

    // Creation d'utilisateurs Acheteurs
    acheteur1 =
      new Acheteur(
        "Austin",
        "Mendez",
        "(210) 701-2246",
        "1615 Tiga Boulevard",
        "jovdepu@ga.bg",
        "pass4"
      );
    acheteur2 =
      new Acheteur(
        "Laura",
        "McDonald",
        "(848) 770-4573",
        "163 Buco View",
        "nogoham@wav.bg",
        "pass5"
      );
    acheteur3 =
      new Acheteur(
        "Trevor",
        "Cole",
        "(754) 525-2581",
        "1922 Mumwem Turnpike",
        "fiw@tujo.ck",
        "pass6"
      );

    // Creation des fournisseurs
    fournisseur1 =
      new Fournisseur("Gordon Martinez", "1991 Hofe Terrace", "(883) 919-8793");
    fournisseur2 =
      new Fournisseur("Nettie Kelly", "721 Ceot Boulevard", "(715) 570-9777");
    fournisseur3 =
      new Fournisseur("Lucy Obrien", "487 Obdub Mill", "(781) 294-3800");
    fournisseur4 =
      new Fournisseur("Evelyn Holt", "1127 Rato Boulevard", "(508) 547-5793");
    fournisseur5 =
      new Fournisseur("Hettie Hayes", "1736 Eniwe Highway", "(653) 506-8142");
    fournisseur6 =
      new Fournisseur("Shawn Lewis", "1054 Kori Avenue", "(640) 278-5610");

    // Creation de vehicules Minibus
    minibus1 =
      new Minibus(
        "Space Tourer",
        "453 Z2ERT2",
        "Peugeot",
        180,
        "Noir",
        7,
        EnumCarburant.DIESELE,
        64190d,
        65000d,
        fournisseur1
      );
    minibus2 =
      new Minibus(
        "Traveller",
        "FFR 32ERT2",
        "Peugeot",
        200,
        "Rouge",
        7,
        EnumCarburant.DIESELE,
        78500d,
        79000d,
        fournisseur2
      );
    minibus3 =
      new Minibus(
        "ProAce",
        "DFSO 89ZA2",
        "Toyota",
        200,
        "Argente",
        9,
        EnumCarburant.DIESELE,
        85900d,
        87000d,
        fournisseur3
      );

    suv4x4_1 =
      new Suv4x4(
        "GLC 250",
        "FSO DSF63E",
        "Mercedes",
        204,
        "Orange",
        EnumCarburant.DIESELE,
        57100d,
        58900d,
        500,
        fournisseur4
      );
    suv4x4_2 =
      new Suv4x4(
        "3008 Hybrid",
        "DSF 4532RE",
        "Peugeot",
        300,
        "Blanc",
        EnumCarburant.DIESELE,
        43990d,
        45000d,
        500,
        fournisseur5
      );
    suv4x4_3 =
      new Suv4x4(
        "CRDI 200 ch",
        "DSF 67S87S",
        "Kia",
        200,
        "Noir",
        EnumCarburant.ESSENCE,
        43990d,
        44400d,
        300,
        fournisseur6
      );

    formulaire1 =
      new FormulaireAchatVehicule(minibus1, (Acheteur) acheteur1, new Date());
    formulaire2 =
      new FormulaireAchatVehicule(minibus2, (Acheteur) acheteur2, new Date());
    formulaire3 =
      new FormulaireAchatVehicule(suv4x4_2, (Acheteur) acheteur2, new Date());
    formulaire4 =
      new FormulaireAchatVehicule(suv4x4_2, (Acheteur) acheteur3, new Date());

    // Sauvegarde des instances dans les collections du magasin

    // Initialisation des donnees du magasin
    magasin.setNomMagasin("Leader Auto");

    magasin.ajouterUtilisateur(concessionaire1);
    magasin.ajouterUtilisateur(concessionaire2);
    magasin.ajouterUtilisateur(concessionaire3);

    magasin.ajouterUtilisateur(acheteur1);
    magasin.ajouterUtilisateur(acheteur2);
    magasin.ajouterUtilisateur(acheteur3);

    magasin.ajouterVehicule(minibus1);
    magasin.ajouterVehicule(minibus2);
    magasin.ajouterVehicule(minibus3);

    magasin.ajouterVehicule(suv4x4_1);
    magasin.ajouterVehicule(suv4x4_2);
    magasin.ajouterVehicule(suv4x4_3);

    magasin.ajouterDemandeAchat(formulaire1);
    magasin.ajouterDemandeAchat(formulaire2);
    magasin.ajouterDemandeAchat(formulaire3);
    magasin.ajouterDemandeAchat(formulaire4);
  }

  /**
   * Teest de modification sur les donnees
   */
  public void editionDonneeTest() {
    Magasin magasin = Magasin.getInstance();

    // changer la couleur d'un vehicule
    magasin.getVoituresEnVente().get(6).setCouleur("Noir clair");
  }
}
