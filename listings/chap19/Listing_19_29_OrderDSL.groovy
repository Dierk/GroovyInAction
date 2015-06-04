def of = "silent word"                    //#1

def buy(n) {
  [shares: { of ->                        //#2
    [:].withDefault { ticker ->           //#3
      println "buy $n shares of $ticker"
    }
  }]
}

buy 200 shares of GOOG
//#1 Define silent word
//#2 Unused parameter
//#3 Map with Closure defining behavior for unknown keys
