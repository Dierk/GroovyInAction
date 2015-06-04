import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class Listing_11_02_SquaresFactors {
    public void process(Document doc) {
/////////// EXAMPLE START
// Java!
// … doc made available here …
Element numbers     = doc.createElement("numbers");
Element description = doc.createElement("description");
doc.appendChild(numbers);
numbers.appendChild(description);
description.setTextContent("Squares and factors of 10..15");

for (int i=10; i <= 15; i++)
{
    Element number = doc.createElement("number");
    numbers.appendChild(number);
    number.setAttribute("value",  String.valueOf(i));
    number.setAttribute("square", String.valueOf(i*i));
    for (int j=2; j < i; j++)
    {
        if (i % j== 0)
        {
            Element factor = doc.createElement("factor");
            factor.setAttribute("value", String.valueOf(j));
            number.appendChild(factor);
        }
    }
}
////////// EXAMPLE END
    }
}
