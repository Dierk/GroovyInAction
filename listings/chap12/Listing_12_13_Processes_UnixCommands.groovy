// works for unix-based systems
def listFiles = 'ls'.execute()
def ignoreCase = "tr '[A-Z]' '[a-z]'".execute()
def reverseSort = 'sort -r'.execute()

listFiles | ignoreCase | reverseSort

reverseSort.waitForOrKill(1000)
if (reverseSort.exitValue()) {
    print reverseSort.err.text
} else {
    print reverseSort.text
}

