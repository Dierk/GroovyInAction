def mac() {
    switch(System.properties.'os.name') {
        case 'Mac OS X': "We're on Mac."; break // no 'return'
        default:         "Oh, well ..."         // no 'return'
    }   
}
println mac()