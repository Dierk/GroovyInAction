class YahooService {
  static getYearEndClosingUnsafe(String ticker, int year) {
    def url = "http://real-chart.finance.yahoo.com/table.csv?" +
        "s=$ticker&a=11&b=1&c=$year&d=11&e=31&f=$year&g=d&ignore=.csv"
    def data = url.toURL().text
    return data.split("\n")[1].split(",")[4].toFloat()
  }

  static getYearEndClosing(String ticker, int year) {
    try {
      getYearEndClosingUnsafe(ticker, year)
    } catch (all) {
      println "Could not get $ticker, returning -1. $all"
      return -1
    }
  }
}
