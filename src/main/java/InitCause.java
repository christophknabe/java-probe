class InitCause {
  public static void main(){
      final String arg = "arg";
      final Throwable ex = null;
      throw (IllegalArgumentException )new IllegalArgumentException(arg).initCause(ex);
  }
}