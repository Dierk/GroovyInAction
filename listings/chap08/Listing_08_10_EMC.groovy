assert String.metaClass =~ /MetaClassImpl/
String.metaClass.low    = {-> delegate.toLowerCase() }
assert String.metaClass =~ /ExpandoMetaClass/

assert "DiErK".low() == "dierk"