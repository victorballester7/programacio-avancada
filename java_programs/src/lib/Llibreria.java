package lib;

public class Llibreria {
  private int id;

  public Llibreria(int id) {
    this.id = id;
  }

  public void printa() {
    System.out.println(id);
  }

  /**
   * @return int
   */
  public int getId() {
    return id;
  }

  /**
   * @param id
   */
  public void setId(int id) {
    this.id = id;
  }
}