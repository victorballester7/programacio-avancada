// package java_programs.src;

import java.io.StreamTokenizer;
// import java.util.Scanner;
//import java.math.*;

public class LlegirTokens {
  public static void main(String[] args) throws Exception {
    // FileInputStream fis = new FileInputStream("java_programs/data/prova.txt");
    // DataInputStream dis = new DataInputStream(fis); // or System.in
    // String s = dis.readLine();
    StreamTokenizer st = new StreamTokenizer(System.in);
    while (st.nextToken() != StreamTokenizer.TT_EOF) {
      if (st.ttype == StreamTokenizer.TT_WORD)
        System.out.println("Paraula: " + st.sval);
      else if (st.ttype == StreamTokenizer.TT_NUMBER)
        System.out.println("Número: " + st.nval);
      else
        System.out.println("ASCII: " + st.ttype);
    }
  }
}
