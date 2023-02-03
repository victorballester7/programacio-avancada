package examensAnteriors;

import java.io.*;
import java.util.*;

public class ex22_4 {
  public static void main(String[] args) {
    try {
      // sectionA();
      // sectionB();
      System.out.println(sectionC());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<City> sectionA() throws Exception {
    ArrayList<String> array = readFile("java_programs/src/examensAnteriors/temp.txt");
    // for (int i = 0; i < array.size(); i++) {
    // System.out.println(array.get(i));
    // }
    String[] aux;
    ArrayList<City> cities = new ArrayList<City>();

    for (int s = 0; s < array.size(); s++) {
      aux = array.get(s).split(" ");
      cities.add(new City(aux[0]));
      for (int i = 1; i < aux.length; i++) {
        cities.get(s).temps.add(Double.valueOf(aux[i]));
      }
    }

    for (City c : cities) {
      System.out.println(c);
    }
    return cities;
  }

  public static ArrayList<City> sectionB() throws Exception {
    ArrayList<String> array = readFileScanner("java_programs/src/examensAnteriors/temp.txt");
    String[] aux;
    ArrayList<City> cities = new ArrayList<City>();

    for (int s = 0; s < array.size(); s++) {
      aux = array.get(s).split(" ");
      cities.add(new City(aux[0]));
      for (int i = 1; i < aux.length; i++) {
        cities.get(s).temps.add(Double.valueOf(aux[i]));
      }
    }

    for (City c : cities) {
      System.out.println(c);
    }
    return cities;
  }

  public static String sectionC() throws Exception {
    ArrayList<City> cities = sectionB();
    double globalMin = cities.get(0).getMin();
    int index = 0;
    for (City c : cities) {
      if (c.getMin() < globalMin) {
        globalMin = c.getMin();
        index = cities.indexOf(c);
      }
    }
    return cities.get(index).name;
  }

  public static class City {
    public String name;
    public ArrayList<Double> temps = new ArrayList<Double>();
    public double min;

    public City(String name) {
      this.name = name;
    }

    public String toString() {
      return name + ": " + temps.toString();
    }

    public double getMin() {
      min = temps.get(0);
      for (Double i : temps)
        min = Math.min(min, i);
      return min;
    }
  }

  public static ArrayList<String> readFileScanner(String fileName) throws Exception {
    Scanner sc = new Scanner(new File(fileName));
    ArrayList<String> array = new ArrayList<String>();
    String s;
    while (true) {
      try {
        s = sc.nextLine();
        array.add(s);
      } catch (Exception e) {
        break;
      }
    }
    return array;
  }

  public static ArrayList<String> readFile(String fileName) throws Exception {
    File file = new File(fileName);
    BufferedReader br = null;
    br = new BufferedReader(new FileReader(file));
    ArrayList<String> array = new ArrayList<String>();
    String s;
    while ((s = br.readLine()) != null)
      array.add(s);
    br.close();
    return array;
  }
}
