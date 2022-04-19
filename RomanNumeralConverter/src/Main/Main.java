package Main;

import Converter.Converter;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanInput = new Scanner(System.in);
    System.out.println("Welcome to the Decimal to Roman Numeral Converter.\nPlease enter a valid decimal number (1-3999), and it will be converted to a roman numeral.");
    String userInput = scanInput.nextLine();

    Converter converter = new Converter();
    try {
      String convertedString=converter.convert(userInput);
      System.out.println("\nYour converted number is: " + convertedString + "\nThank you for using the Decimal to Roman Numeral Converter.");
    }
    catch(NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }


}
