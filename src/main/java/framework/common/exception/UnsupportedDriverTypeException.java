package framework.common.exception;

public class UnsupportedDriverTypeException extends RuntimeException
{
  private static final long serialVersionUID = -7536364016458937568L;

  public UnsupportedDriverTypeException( String msg )
  {
    super( msg );
  }
}
