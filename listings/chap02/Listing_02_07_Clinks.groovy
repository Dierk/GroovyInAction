def totalClinks = 0
def partyPeople = 100
1.upto(partyPeople) { guestNumber ->
    clinksWithGuest = guestNumber-1
    totalClinks += clinksWithGuest                     //#A
}
assert totalClinks == (partyPeople * (partyPeople-1)) / 2
//#A Modifies outer scope