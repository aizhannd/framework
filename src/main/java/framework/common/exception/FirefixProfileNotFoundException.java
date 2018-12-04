package framework.common.exception;

public class FirefixProfileNotFoundException extends RuntimeException
{
  private static final long serialVersionUID = -986363530605583182L;

  public FirefixProfileNotFoundException( String message )
  {
    super( message );
  }

  public FirefixProfileNotFoundException( Throwable cause )
  {
    super( cause );
  }
}
