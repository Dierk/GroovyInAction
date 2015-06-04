import groovyx.gpars.dataflow.Dataflows
import static YahooService.getYearEndClosing
import static groovyx.gpars.dataflow.Dataflow.task

def tickers = ['AAPL', 'GOOG', 'IBM', 'ORCL', 'MSFT']

def price = new Dataflows()
tickers.each { ticker ->
  task { price[ticker] = getYearEndClosing(ticker, 2014) }     //#A
}
def top = tickers.max { price[it] }                            //#B
assert top == 'GOOG' && price[top] == 526.4f
//#A Set when available
//#B Read sequentially
