File tempDir = File.createTempDir()                          //#A

assert tempDir.directorySize() == 0                          //#B

File source = new File(tempDir, 'input.dat')                 //#C
source.bytes = "hello world".bytes

assert tempDir.directorySize() == 11                         //#D

File destination = new File(tempDir, 'output.dat')

destination.withDataOutputStream { os->                      //#E
    source.withDataInputStream { is->
        os << is
    }
}

assert tempDir.directorySize() == 22

tempDir.deleteDir()                                         //#F
//#A Create a temporary directory
//#B Check that the directory is empty
//#C Create a file and set the file contents
//#D Check that the directory size increased
//#E Copy the file and check that the directory size doubled
//#F Delete the directory
