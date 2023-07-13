package enums;

public enum MovieType {
  REGULAR("regular"),
  NEW("new"),
  CHILDRENS("childrens");

  private final String value;

  private MovieType(String value) {
      this.value = value;
  }

  public String getValue() {
      return value;
  }
}

