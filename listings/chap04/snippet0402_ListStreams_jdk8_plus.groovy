def urls = [
    new URL('http', 'myshop.com', 80, 'index.html'),
    new URL('https', 'myshop.com', 443, 'buynow.html'),
    new URL('ftp', 'myshop.com', 21, 'downloads')
]

// Groovy with Java 8
import java.util.stream.Collectors
def commaSep = Collectors.joining(", ")
assert urls.stream()
    .filter{ it.port < 99 }
    .map{ it.file.toUpperCase() }
    .sorted()
    .collect(commaSep) == 'DOWNLOADS, INDEX.HTML'
