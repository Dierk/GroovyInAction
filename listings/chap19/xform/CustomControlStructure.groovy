package xform

import java.lang.annotation.*
import org.codehaus.groovy.transform.*

@Retention(RetentionPolicy.SOURCE)                                  //#1
@Target(ElementType.TYPE)                                           //#2
@GroovyASTTransformationClass(classes = [WhenUntilTransform])       //#3
@interface CustomControlStructure {}
//#1 Annotation thrown away before runtime
//#2 Class annotation
//#3 Reference to transform implementation class
