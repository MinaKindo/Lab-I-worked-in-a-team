package exceptions;

public class RecoveryRateException extends Exception {
  
  public RecoveryRateException(String s)  {
    System.out.println("Recovery not valid!");
  }
}
