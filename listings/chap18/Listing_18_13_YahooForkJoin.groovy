import static groovyx.gpars.GParsPool.withPool
import static YahooService.getYearEndClosing

def tickers = ['AAPL', 'GOOG', 'IBM', 'ORCL', 'MSFT']

withPool(tickers.size()) {
  def top = tickers.makeConcurrent()
      .collect { [ticker: it, price: getYearEndClosing(it, 2014)] }
      .max { it.price }
  assert top == [ticker: 'GOOG', price: 526.4f]
}