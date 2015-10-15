package v03.model

enum DistanceUnit {
  centimeter('cm', 0.01),
  meter     ( 'm',    1),
  kilometer ('km', 1000)

  String abbreviation
  double multiplier

  DistanceUnit(String abbr, double mult) {
    this.abbreviation = abbr
    this.multiplier = mult
  }

  String toString() { abbreviation }
}
