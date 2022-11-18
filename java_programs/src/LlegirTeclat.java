package java_programs.src;

// import java.io.DataInputStream;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.IOException;
import java.util.Scanner;
//import java.math.*;

public class LlegirTeclat {
  public static void main(String[] args) throws Exception {
    // try{
    // // FileInputStream fis = new FileInputStream("java_programs/data/prova.txt");
    // // DataInputStream dis = new DataInputStream(fis); // or System.in
    // // String s = dis.readLine();
    // } catch (IOException e){ //catch (Exception e){ // general error
    // // we treat the error here
    // }
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt(), j = sc.nextInt();
    System.out.println("La suma és: " + (i + j));
    System.out.println("El log de la suma és: " + (Math.log(i + j)));
    sc.close();
  }
}
