import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

// instantiate hero object
   @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero myHero = new Hero("Mzito");
    assertEquals(true, myHero instanceof Hero);
  }

// assigns each Mzito a name and retrieves it
   @Test
  public void Hero_instantiatesWithDescription_String() {
    Hero myHero = new Hero("Mzito");
    assertEquals("Mzito", myHero.getDescription());
  }

}