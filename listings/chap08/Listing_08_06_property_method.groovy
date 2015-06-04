class NoParens {
    def getProperty(String propertyName) {
        if (metaClass.hasProperty(this, propertyName)) { //#1
            return metaClass.getProperty(this, propertyName)
        }
       invokeMethod propertyName, null  //#2
    }
}

class PropUser extends NoParens {       //#3
    boolean existingProperty = true
}

def user = new PropUser()
assert user.existingProperty
assert user.toString() == user.toString //#4