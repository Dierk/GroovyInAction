import static groovyx.gpars.GParsPool.withPool
import static YahooService.getYearEndClosing

def ticker = ['AAPL', 'GOOG', 'IBM', 'ORCL', 'MSFT']

withPool(ticker.size()) {
  def top = ticker.parallel
      .map { [ticker: it, price: getYearEndClosing(it, 2014)] }
      .max { it.price }
  assert top == [ticker: 'GOOG', price: 526.4f]
}