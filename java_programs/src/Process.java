// package java_programs.src;

public class Process extends Thread {
  int id;

  Process(int id) {
    this.id = id;
  }

  public void run() {
    for (int i = 1; i <= 200; i++) {
      System.out.println("El proces " + id + " mostra el " + i);
    }
  }

  public static void main(String[] args) {
    Process p1 = new Process(1);
    Process p2 = new Process(2);
    Process p3 = new Process(3);
    p3.setPriority(MAX_PRIORITY);
    p1.start();
    p2.start();
    p3.start();
  }
}
