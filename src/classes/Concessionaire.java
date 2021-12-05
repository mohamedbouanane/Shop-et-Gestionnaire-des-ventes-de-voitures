package classes;

public class Concessionaire extends AbstractUtilisateur {
  private String nomComplet;

  public Concessionaire() {
    super();
  }

  public Concessionaire(
    String identifiant,
    String motDePasse,
    String nomComplet
  ) {
    super(identifiant, motDePasse);
    this.nomComplet = nomComplet;
  }

  /**
   * @return String return the nomComplet
   */
  public String getNomComplet() {
    return nomComplet;
  }

  /**
   * @param nomComplet the nomComplet to set
   */
  public void setNomComplet(String nomComplet) {
    this.nomComplet = nomComplet;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
