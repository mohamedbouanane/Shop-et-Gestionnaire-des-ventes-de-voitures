package classes;

public class Concessionaire extends AbstractUtilisateur {
  private String cin;

  public Concessionaire() {
    super();
  }

  public Concessionaire(String username, String motDePasse, String cin) {
    super(username, motDePasse);
    this.cin = cin;
  }
}
