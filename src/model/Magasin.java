package model;

import java.util.Map;

/**
 * Classe bilant sur les dépences et les revenues du magasin
 * Ces derniers sont calculé à partir des ajouts et des confirmations de ventes des véhicules
 */
public class Magasin {
  // ________________________ Attributes ________________________

  private String nom;
  private Double dépences;
  private Double revenues;
  private Double benefice;

  /** Collection des véhicule du magasin
   * src doc : https://www.jmdoudoux.fr/java/dej/chap-collections.htm
   */
  private Map<Integer, Vehicule> collectionVehicules;

  // ________________________ Constructeurs ________________________

  /** Constructeur vide */
  public Magasin() {}

  /** Constructeur Complet */
  public Magasin(
    String nom,
    Double dépences,
    Double revenues,
    Double benefice,
    Map<Integer, Vehicule> collectionVehicules
  ) {
    this.nom = nom;
    this.dépences = dépences;
    this.revenues = revenues;
    this.benefice = benefice;
    this.collectionVehicules = collectionVehicules;
  }

  // ________________________ Accesseurs ________________________

  public Map<Integer, Vehicule> getCollectionVehicules() {
    return this.collectionVehicules;
  }

  public void setCollectionVehicules(
    Map<Integer, Vehicule> collectionVehicules
  ) {
    this.collectionVehicules = collectionVehicules;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Double getDépences() {
    return this.dépences;
  }

  public void setDépences(Double dépences) {
    this.dépences = dépences;
  }

  public Double getRevenues() {
    return this.revenues;
  }

  public void setRevenues(Double revenues) {
    this.revenues = revenues;
  }

  public Double getBenefice() {
    return this.benefice;
  }

  public void setBenefice(Double benefice) {
    this.benefice = benefice;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      ", nom='" +
      getNom() +
      "'" +
      ", dépences='" +
      getDépences() +
      "'" +
      ", revenues='" +
      getRevenues() +
      "'" +
      ", benefice='" +
      getBenefice() +
      "'" +
      " collectionVehicules='" +
      getCollectionVehicules() +
      "'" +
      "}"
    );
  }
}
