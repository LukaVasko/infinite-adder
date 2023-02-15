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
      if (num1.hasNext()) {
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

    while (num2.hasNext()) {
      curr2.digit = num2.nextInt();
      if (num2.hasNext()) {
        prev2 = curr2;
        curr2.next = new Digit();
        curr2 = curr2.next;
        curr2.prev = prev2;
      }
    }
    Digit tail2 = curr2;

    // Calculate
    int carry = 0;
    Digit head3 = null;
    Digit tail3 = null;

    while (tail1 != null || tail2 != null) {
      int sum = carry;
      if (tail1 != null) {
        sum += tail1.digit;
        tail1 = tail1.prev;
      }
      if (tail2 != null) {
        sum += tail2.digit;
        tail2 = tail2.prev;
      }
      int digit = sum % 10;
      carry = sum / 10;

      Digit newDigit = new Digit();
      newDigit.digit = digit;
      if (tail3 == null) {
        head3 = newDigit;
        tail3 = newDigit;
      } else {
        newDigit.next = head3;
        head3.prev = newDigit;
        head3 = newDigit;
      }
    }

    if (carry > 0) {
      Digit newDigit = new Digit();
      newDigit.digit = carry;
      newDigit.next = head3;
      head3.prev = newDigit;
      head3 = newDigit;
    }

    // Print the result
    System.out.print("Result: ");
    curr1 = head3;
    while (curr1 != null) {
      System.out.print(curr1.digit);
      curr1 = curr1.next;
    }
    System.out.println();

    System.exit(0);

  }
}
