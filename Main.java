import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args)throws IOException {
    ArrayList<String> follower = new ArrayList<>();
    ArrayList<String> following = new ArrayList<>();
    boolean isOdd = false;
    //read every odd line due to formating

    File followers = new File("followers.txt");
    Scanner readFollowers = new Scanner(followers);
    while (readFollowers.hasNextLine()) {
      String line = readFollowers.nextLine();
      if (!isOdd) {
        follower.add(line);
      }

      isOdd = !isOdd;
    }
    readFollowers.close();
  


    //your followers section

    File you = new File("youfollowing.txt");
    Scanner readYou = new Scanner(you);
    while (readYou.hasNextLine()) {
      String line = readYou.nextLine();
      if (!isOdd) {
        following.add(line);
      }

      isOdd = !isOdd;
    }
    readYou.close();

    // from stackoverflow https://stackoverflow.com/questions/61116787/compare-two-list-and-output-missing-and-extra-element-in-java
    //y-following
    //f-follower
    Set<String> Y = new HashSet<>(following);
    Set<String> F = new HashSet<>(follower);

    Set<String> copyF= new HashSet<>(F);
    Set<String> copyY= new HashSet<>(Y);

    
    copyF.removeAll(Y);
    System.out.println("Account you do not follow back: " + copyF);

    copyY.removeAll(F);
    System.out.println("Account that do not follow you back: " + copyY);
    

 
    
  }
}
