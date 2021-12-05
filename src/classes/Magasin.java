package classes;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Classe bilan sur les depences et les revenus du magasin
 * (Integre le design pattern : singleton)
 */
public class Magasin implements InterfaceMagasin {
  // ________________________ Attributs

  private static AbstractUtilisateur utilisateurEnCours;

  private static Magasin magasin;

  /** Variable d'incrementation pour les identifiants des collections */
  private Long cptIdVehicules = 0L;
  private Long cptIdUtilisateur = 0L;
  private Long cptIdFormulaireAchatVehicule = 0L;

  private String nom;

  /** Collection des vehicules du magasin
   * Map doc : https://www.geeksforgeeks.org/treemap-in-java
   */
  private Map<Long, AbstractVehicule> collectionVehicules;
  private Map<Long, AbstractUtilisateur> collectionUtilisateurs;
  private Map<Long, FormulaireAchatVehicule> collectionFormulaireAchatVehicules;

  // ________________________ Constructeurs

  /** Constructeur vide */
  private Magasin() {
    collectionVehicules = new TreeMap<>();
    collectionUtilisateurs = new TreeMap<>();
    collectionFormulaireAchatVehicules = new TreeMap<>();
  }

  /** Design pattern : singleton (Classe Magasin) */
  public static Magasin getInstance() {
    if (magasin == null) {
      magasin = new Magasin();
      return magasin;
    } else {
      return magasin;
    }
  }

  // ________________________ Accesseurs

  /* Getter */
  public Map<Long, AbstractVehicule> getCollectionVehicules() {
    return this.collectionVehicules;
  }

  public Map<Long, AbstractUtilisateur> getCollectionUtilisateurs() {
    return this.collectionUtilisateurs;
  }

  public Map<Long, FormulaireAchatVehicule> getCollectionFormulaireAchatVehicules() {
    return this.collectionFormulaireAchatVehicules;
  }

  public String getNomMagasin() {
    return this.nom;
  }

  public void setNomMagasin(String nom) {
    this.nom = nom;
  }

  public AbstractUtilisateur getUtilisateurEnCours() {
    return utilisateurEnCours;
  }

  public void setUtilisateurEnCours(AbstractUtilisateur abstractUtilisateur) {
    utilisateurEnCours = abstractUtilisateur;
  }

  // ________________________ Methodes

  public Double getDepences() {
    Double depences = 0d;
    for (AbstractVehicule vehicule : collectionVehicules.values()) {
      depences += vehicule.getPrixAchat();
    }
    return depences;
  }

  public Double getRevenus() {
    Double revenus = 0d;
    for (FormulaireAchatVehicule formulaire : collectionFormulaireAchatVehicules.values()) {
      if (formulaire.getIsAchatFinalise() == true) {
        revenus += formulaire.getVehicule().getPrixVente();
      }
    }
    return revenus;
  }

  public Double getBenefices() {
    return getRevenus() - getDepences();
  }

  // ________________________ Methodes

  public void ajouterUtilisateur(AbstractUtilisateur utilisateur) {
    cptIdUtilisateur = cptIdUtilisateur + 1;
    collectionUtilisateurs.putIfAbsent(cptIdUtilisateur, utilisateur);
  }

  public void ajouterVehicule(AbstractVehicule vehicule) {
    cptIdVehicules = cptIdVehicules + 1;
    collectionVehicules.putIfAbsent(cptIdVehicules, vehicule);
  }

  public void modifierVehicule(Long key, AbstractVehicule vehicule) {
    collectionVehicules.put(key, vehicule);
  }

  public void supprimerVehicule(Long key) {
    collectionVehicules.remove(key);
  }

  public void ajouterDemandeAchat(FormulaireAchatVehicule formulaire) {
    cptIdFormulaireAchatVehicule++;
    collectionFormulaireAchatVehicules.putIfAbsent(
      cptIdFormulaireAchatVehicule,
      formulaire
    );
  }

  public void annulerDemandeAchat(Long key) {
    collectionFormulaireAchatVehicules.remove(key);
  }

  public Map<Long, AbstractVehicule> getVoituresEnVente() {
    Map<Long, AbstractVehicule> voituresEnVente = new TreeMap<>();

    for (Map.Entry<Long, FormulaireAchatVehicule> formulaire : collectionFormulaireAchatVehicules.entrySet()) {
      // Regrouppement des achats  pas encor confirme
      if (formulaire.getValue().getIsAchatFinalise() == false) {
        voituresEnVente.put(
          formulaire.getKey(), // key
          getCollectionVehicules().get(formulaire.getKey()) // value
        );
      }
    }

    return voituresEnVente;
  }

  public Map<Long, FormulaireAchatVehicule> getFormulairesCommandesAcheteur(
    Acheteur acheteur
  ) {
    Map<Long, FormulaireAchatVehicule> formulairesCommandesAcheteur = new TreeMap<>();

    for (Map.Entry<Long, FormulaireAchatVehicule> formulaire : getCollectionFormulaireAchatVehicules()
      .entrySet()) {
      // Regrouppement des commandes effectue par le client
      if (formulaire.getValue().getAcheteur() == acheteur) {
        formulairesCommandesAcheteur.put(
          formulaire.getKey(), // key
          getCollectionFormulaireAchatVehicules().get(formulaire.getKey()) // value
        );
      }
    }

    return formulairesCommandesAcheteur;
  }

  @Override
  public String toString() {
    return (
      "Nom du magasin:\t" +
      magasin.getNomMagasin() +
      "\n\n- Depences:\t" +
      magasin.getDepences() +
      "\n- Revenus:\t" +
      magasin.getRevenus() +
      "\n- Benefices:\t" +
      magasin.getBenefices()
    );
  }
}
