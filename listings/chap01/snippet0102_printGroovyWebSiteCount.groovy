import static groovyx.gpars.GParsPool.withPool

def urls = [
        'https://www.groovy-lang.org',
        'http://gpars.org',
        'https://gr8conf.org/'
]*.toURL()

println withPool {
    urls.collectParallel {
        it.text.findAll(~/[Gg]roovy/).size()
    }
}
