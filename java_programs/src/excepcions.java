// package java_programs.src;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class excepcions {
  public static void main(String[] args) throws Exception {
    f();
  }

  static void f() {
    try {
      FileInputStream fis = new FileInputStream("java_programs/data/prova.txt");
      DataInputStream dis = new DataInputStream(fis); // or System.in
      String s = dis.readLine();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
      e.printStackTrace();
      System.out.println("Error!!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Error!!");

    }
  }
}
