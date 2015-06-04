file = new File('objects.dat')
file.deleteOnExit()                                //#A

objects = [1, "Hello Groovy!", new Date()]
file.withObjectOutputStream { outstream ->
  objects.each {
    outstream << it                                //#B
  }
}

retrieved = []
file.withObjectInputStream { instream ->
  instream.eachObject {
    retrieved << it                                //#C
  }
}

assert retrieved == objects
//#A Clean up after ourselves
//#B Serialize each object in the list in turn
//#C Deserialize each object in turn
