ant = new AntBuilder()
if ( ! System.properties.'java.version'.contains('1.7')) {
    ant.fail 'This build script requires JDK 1.7.x but was ' +
        System.properties.'java.version'
} 
// further action