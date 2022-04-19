package Converter;

public class Converter {

  //Completed in two hours (test included)
  //Some of these can be converted to local variables, but are kept this way for clarity
  private final String ONE_NUMERAL = "I";
  private final String FIVE_NUMERAL = "V";
  private final String TEN_NUMERAL = "X";
  private final String FIFTY_NUMERAL = "L";
  private final String HUNDRED_NUMERAL = "C";
  private final String FIVE_HUNDRED_NUMERAL = "D";
  private final String THOUSAND_NUMERAL = "M";

  public Converter() {}
  public String convert(String userInput) throws NumberFormatException
  {

    int userNumber = verifyInput(userInput);

    StringBuilder converted_number = new StringBuilder();
    //Loops through until the number goes to 0
    while(userNumber != 0) {
      if(userNumber >= 1000) {
        converted_number.append(THOUSAND_NUMERAL);
        //Would be possible to insert a loop into this if statement multiple times if 2000 or greater,
        //But not done for clarity
        userNumber = userNumber-1000;
      }
      //This range (and corresponding ones not a direct numeral) determine whether to add the additional previous numeral
      else if(userNumber >= 900) {
        converted_number.append(HUNDRED_NUMERAL);
        converted_number.append(THOUSAND_NUMERAL);
        userNumber = userNumber%900;
      }
      else if(userNumber/500 > 0) {
        converted_number.append(FIVE_HUNDRED_NUMERAL);
        userNumber = userNumber%500;
      }
      else if(userNumber >= 400) {
        converted_number.append(HUNDRED_NUMERAL);
        converted_number.append(FIVE_HUNDRED_NUMERAL);
        userNumber = userNumber%400;
      }
      else if(userNumber/100 > 0) {
        converted_number.append(HUNDRED_NUMERAL);
        userNumber = userNumber-100;
      }
      else if(userNumber >= 90) {
        converted_number.append(TEN_NUMERAL);
        converted_number.append(HUNDRED_NUMERAL);
        userNumber = userNumber%90;
      }
      else if(userNumber/50 > 0) {

        converted_number.append(FIFTY_NUMERAL);
        userNumber = userNumber%50;

      }
      else if(userNumber >= 40) {
        converted_number.append(TEN_NUMERAL);
        converted_number.append(FIFTY_NUMERAL);
        userNumber = userNumber%40;
      }
      else if(userNumber/10 > 0) {

        converted_number.append(TEN_NUMERAL);
        userNumber = userNumber-10;
      }
      else if(userNumber == 9) {
        converted_number.append(ONE_NUMERAL);
        converted_number.append(TEN_NUMERAL);
        userNumber = 0;
      }
      else if(userNumber/5 > 0) {

        converted_number.append(FIVE_NUMERAL);
        userNumber = userNumber%5;
      }
      else if(userNumber == 4) {
        converted_number.append(ONE_NUMERAL);
        converted_number.append(FIVE_NUMERAL);
        userNumber = 0;
      }
      else if(userNumber > 0) {
        converted_number.append(ONE_NUMERAL);
        userNumber = userNumber-1;
      }
    }
    return converted_number.toString();
  }
  //Try-catch checks if userInput is a genuine number, or one in range
  private int verifyInput(String userInput) {
    try {
      int userNumber = Integer.parseInt(userInput);
      if(userNumber == 0 || userNumber > 3999) {
        throw new NumberFormatException();
      }
      return userNumber;
    }
    catch(NumberFormatException e) {
      throw new NumberFormatException("\nA decimal number that can be calculated was not given. Please provide another number after running again.");
    }
  }

}
