package classes;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Classe bilan sur les dépences et les revenus du magasin
 * (Integre le design pattern : singleton)
 */
public class Magasin {
  // ________________________ Attributs

  private static AbstractUtilisateur utilisateurEnCours;

  private static Magasin magasin;

  /** Variable d'incrémentation pour les identifiants des collections */
  private static Long cptIdVehicules = 0L;
  private static Long cptIdUtilisateur = 0L;
  private static Long cptIdFormulaireAchatVehicule = 0L;

  private String nom;

  /** Collection des véhicules du magasin
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
      return new Magasin();
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

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public AbstractUtilisateur getUtilisateurEnCours() {
    return utilisateurEnCours;
  }

  public void setUtilisateurEnCours(AbstractUtilisateur abstractUtilisateur) {
    utilisateurEnCours = abstractUtilisateur;
  }

  /** Retourne le montant totale des dépences */
  public Double getDepences() {
    Double depences = 0d;
    for (Entry<Long, AbstractVehicule> vehicule : collectionVehicules.entrySet()) {
      depences += vehicule.getValue().getPrixAchat();
    }
    return depences;
  }

  /** Retourne le montant totale des entrées d’argent */
  public Double getRevenus() {
    Double revenus = 0d;
    for (Entry<Long, FormulaireAchatVehicule> formulaire : collectionFormulaireAchatVehicules.entrySet()) {
      if (formulaire.getValue().isAchatFinalise() == true) {
        revenus += formulaire.getValue().getVehicule().getPrixVente();
      }
    }
    return revenus;
  }

  /** Retourne le montant totale des benefices */
  public Double getBenefices() {
    return getRevenus() - getDepences();
  }

  // ________________________ Méthodes

  public void ajouterUtilisateur(AbstractUtilisateur utilisateur) {
    collectionUtilisateurs.put(cptIdUtilisateur, utilisateur);
    cptIdUtilisateur = cptIdUtilisateur + 1;
  }

  public void ajouterVehicule(AbstractVehicule vehicule) {
    collectionVehicules.put(cptIdVehicules, vehicule);
    cptIdVehicules = cptIdVehicules + 1;
  }

  public void ajouterDemandeAchat(FormulaireAchatVehicule formulaire) {
    collectionFormulaireAchatVehicules.put(
      cptIdFormulaireAchatVehicule,
      formulaire
    );
  }

  // ________________________ Méthodes

  /**
   * Retourne les véhicules pas encor vendue
   * */
  public Map<Long, AbstractVehicule> getVoituresEnVente() {
    Map<Long, AbstractVehicule> voituresEnVente = new TreeMap<>();

    for (Map.Entry<Long, FormulaireAchatVehicule> formulaire : getCollectionFormulaireAchatVehicules()
      .entrySet()) {
      // Regrouppement des achats  pas encor confirmé
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
      // Regrouppement des commandes effectué par le client
      if (formulaire.getValue().getAcheteur() == acheteur) {
        formulairesCommandesAcheteur.put(
          formulaire.getKey(), // key
          getCollectionFormulaireAchatVehicules().get(formulaire.getKey()) // value
        );
      }
    }

    return formulairesCommandesAcheteur;
  }

  // ________________________ ToString

  @Override
  public String toString() {
    return (
      "{" +
      ", benefice='" +
      getBenefices() +
      "'" +
      ", collectionVehicules='" +
      getCollectionVehicules() +
      "'" +
      ", collectionUtilisateur='" +
      getCollectionUtilisateurs() +
      "'" +
      "}"
    );
  }
}
