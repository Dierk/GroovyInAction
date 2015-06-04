// Java snippet
int totalClinks = 0;
int partyPeople = 100;
for(int guestNumber = 1;
        guestNumber <= partyPeople;
        guestNumber++) {
    int clinksWithGuest = guestNumber-1;
    totalClinks += clinksWithGuest;
}