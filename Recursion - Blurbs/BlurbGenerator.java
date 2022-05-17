import java.util.Random;

/**
 * In the language of an alien race, all words take the form of Blurbs.
 * A Blurb is a Whoozit followed by one or more Whatzits.
 * A Whoozit is the character 'x' followed by zero or more 'y's.
 * A Whatzit is a 'q' followed by either a 'z' or a 'd', followed
 * by a Whoozit.
 * 
 * Solution to Programming Project 17.5
 * 
 * @author Java Foundations / Jonathon Zempel
 *
 * @version 2021-07-27
 */
public class BlurbGenerator {
  private Random gen;

  /**
   * Instantiates a random number generator needed for blurb creation.
   */
  public BlurbGenerator() {
    gen = new Random();
  }

  /**
   * Generates and returns a random Blurb. A Blurb is a Whoozit
   * followed by one or more Whatzits.
   */
  public String makeBlurb() {
    return makeWhoozit() + makeMultiWhatzits();
  }

  /**
   * Generates a random Whoozit. A Whoozit is the character 'x'
   * followed by zero or more 'y's.
   */
   // x -> makeYString()
  private String makeWhoozit() {
    //System.out.println("makeWhoozit() unimplemented.");
    String whoozit = "x";
    return whoozit + makeYString();
  }

  /**
   * Recursively generates a string of zero or more 'y's.
   * 
   */
   //decide:  y -> makeYstring() or no
  private String makeYString() {
    //System.out.println("makeYString() unimplemented.");
    
    String yString = "";
    //int numYs = gen.nextInt();
    
    if (gen.nextInt() % 2 == 0){
      yString += ("y" + makeYString());
      return yString;
    }
    else 
      return yString;
    

     

    //return yString;
  }


  /**
   * Recursively generates a string of one or more Whatzits.
   */
  private String makeMultiWhatzits() {
    String whatzits = makeWhatzit();

    if (gen.nextBoolean()) {
      whatzits += makeMultiWhatzits();
    }

    return whatzits;
  }

  /**
   * Generates a random Whatzit. A Whatzit is a 'q' followed by
   * either a 'z' or a 'd', followed by a Whoozit.
   */
   // add q then (decide: add d or add Z) -> makeWhoozit()
  private String makeWhatzit() {
    //System.out.println("makeWhatzit() unimplemented.");
    String whatzit = "q";
    if (gen.nextInt() % 2 == 0) 
      whatzit += "d";
    else 
      whatzit += "Z";
    return whatzit + makeWhoozit();

    //return whatzit;
  }
} // class BlurbGenerator
