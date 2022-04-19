package Converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
  Converter convert;

  //Not necc., but still good if hypothetical future patches make a new object required per run.
  @BeforeEach
  void setup()
  {
    convert = new Converter();
  }

  @Test
  void convertMinEdge() {
    //This will test the edge cases 1, using assertEquals on string since roman numerals can only be capital
    Assertions.assertEquals("I", convert.convert("1"));
  }

  @Test
  void convertMaxEdge() {
    //This will test the edge case 3999
    Assertions.assertEquals("MMMCMXCIX", convert.convert("3999"));
  }

  @Test
  void convertOverEdge() {
    //This will test over the edge case 3999
    Exception exception = assertThrows(NumberFormatException.class, () -> convert.convert("4000"));

    String expectedMessage = "\nA decimal number that can be calculated was not given. Please provide another number after running again.";
    String realMessage = exception.getMessage();
    Assertions.assertEquals(expectedMessage, realMessage);
  }

  @Test
  void convertUnderEdge() {
    //This will test under the edge case 1
    Exception exception = assertThrows(NumberFormatException.class, () -> convert.convert("0"));

    String expectedMessage = "\nA decimal number that can be calculated was not given. Please provide another number after running again.";
    String realMessage = exception.getMessage();
    Assertions.assertEquals(expectedMessage, realMessage);
  }

  //I am not confident on grabbing other github repositories, but I would create another test where I randomize
  //ten numbers within the limits (1-3999) and use third-party software to compare my roman numerals to theirs.
}