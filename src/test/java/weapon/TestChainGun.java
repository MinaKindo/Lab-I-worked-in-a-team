package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;

public class TestChainGun {

  /**
   * Kamrin Langan
   * 
   */
  
  /**
   * 
   * @throws WeaponException
   */
  @Test
  public void testAmmoUpdate() throws WeaponException {
    
    ChainGun cg = new ChainGun();
    
    cg.fire(15);
    assertEquals(39, cg.getCurrentAmmo());
    
    cg.currentAmmo = 0;
    assertEquals(0, cg.fire(29));
    
    //cg.reload();
    //assertEquals(cg.maxAmmo, cg.currentAmmo);
    
  }

}
