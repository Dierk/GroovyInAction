class StringCasingCategory {
  static String lower(String string) {
    return string.toLowerCase()
  }
}

use(StringCasingCategory) {
  assert "groovy" == "GroOvy".lower()
}
