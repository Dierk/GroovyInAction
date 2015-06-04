import groovy.transform.Immutable

@Immutable                                             //#1
class Money {
    int     amount
    String  currency

    Money plus (Money other) {                         //#2
        if (null == other) return this
        if (other.currency != currency) {
            throw new IllegalArgumentException(
                "cannot add $other.currency to $currency")
        }
        return new Money(amount + other.amount, currency)
    }        
}

Money  buck = new Money(1, 'USD')
assert buck 
assert buck        == new Money(1, 'USD')              //#3
assert buck + buck == new Money(2, 'USD')              //#4
//#1 Overrides == operator
//#2 Implements + operator
//#3 Use overridden ==
//#4 Use implemented +
