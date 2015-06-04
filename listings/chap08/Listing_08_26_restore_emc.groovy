MetaClass oldMetaClass = String.metaClass           //#1

MetaMethod alias = String.metaClass.metaMethods     //#2
                   .find { it.name == 'size' }
String.metaClass {
    oldSize = { -> alias.invoke delegate  }
    size    = { -> oldSize() * 2 }
}

assert "abc".size()    == 6
assert "abc".oldSize() == 3

if (oldMetaClass.is(String.metaClass)){
    String.metaClass {                              //#3
        size    = { -> alias.invoke delegate }
        oldSize = { -> throw new UnsupportedOperationException() }
    }
} else {
    String.metaClass = oldMetaClass                 //#4
}

assert "abc".size() == 3