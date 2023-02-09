import java.io.*;
import java.util.Scanner;

class Main {
  public static void main(String args[]) throws IOException {
    
    Scanner num1 = new Scanner(new BufferedReader(new FileReader("num1.txt")));
    Scanner num2 = new Scanner(new BufferedReader(new FileReader("num2.txt")));

    // Scan 1st File
    Digit head1 = new Digit();
    Digit curr1 = head1;
    Digit prev1 = head1;
    
    while (num1.hasNext()) {
      curr1.digit = num1.nextInt();
      if(num1.hasNext()) {
      prev1 = curr1;
      curr1.next = new Digit();
      curr1 = curr1.next;
      curr1.prev = prev1;
      }
    }
    Digit tail1 = curr1; 

    
    // Scan 2nd File
    Digit head2 = new Digit();
    Digit curr2 = head2;
    Digit prev2 = head2;
    
    while (num1.hasNext()) {
      curr2.digit = num1.nextInt();
      if(num1.hasNext()) {
      prev2 = curr2;
      curr2.next = new Digit();
      curr2 = curr2.next;
      curr2.prev = prev2;
      }
    }
    Digit tail2 = curr2;

    // Calculate

  }
}
