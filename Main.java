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
    int sum = 0;
    Digit tail3 = new Digit;
    Digit curr3 = tail3;
    Digit prev3 = tail3;
    
    curr3.digit = tail1.digit + tail2.digit;
    if(curr3.digit >= 10) {curr3.digit -= 10; sum++;} 
    while(curr2.prev != null && curr1.prev != null) {
      prev3 = curr3;
      curr3.next = new Digit();
      curr3 = curr3.next;
      curr3.digit = curr2.digit + curr1.digit + sum;
      if(curr3.digit >= 10) {sum++; curr3.digit -= 10;}
      curr2 = curr2.prev;
      curr1 = curr1.prev;
    }
    while(curr1.prev != null && curr2.prev == null) {
      prev3 = curr3;
      curr3.next = new Digit();
      curr3 = curr3.next;
      curr3.digit = curr1.digit;
      curr1 = curr1.prev;
    }
    while(curr1.prev == null && curr2.prev != null) {
      prev3 = curr3;
      curr3.next = new Digit();
      curr3 = curr3.next;
      curr3.digit = curr2.digit;
      curr2 = curr2.prev;
    }

    while(curr3.prev != null) {
      System.out.print(curr3.digit);
      curr3 = curr3.prev;
    }

  }
}
