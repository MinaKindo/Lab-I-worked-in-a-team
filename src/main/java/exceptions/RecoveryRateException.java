package exceptions;

public class RecoveryRateException extends Throwable {
  
  public RecoveryRateException(String s)  {
    System.out.println("Recovery not valid!");
  }
}
