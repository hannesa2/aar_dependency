## Use an aar library cause missing dependencies using _api_ 

When I build an app with a *.aar file instead of the module with Android O (Gradle 4.x) 

```
 dependencies {
    api 'com.example.my.mylibrary:mylibrary-debug@aar'
```
Following the [docu] concerning _implements_ and _api_, I expect using _api_ the included aar file has all dependencies included, but it hasn't.

When you do 
```
git clone https://github.com/hannesa2/aar_dependency
./gradlew clean assembleDebug
```
it works properly.

But when I use insted of lib-module the previous generated *.aar file as dependency
```
git checkout with_aar
./gradlew clean assembleDebug
`````
I run into this 
```
> Task :app:transformClassesWithDesugarForDebug
Exception in thread "main" java.lang.TypeNotPresentException: Type io.reactivex.ObservableTransformer not present
        at sun.invoke.util.BytecodeDescriptor.parseSig(BytecodeDescriptor.java:85)
        at sun.invoke.util.BytecodeDescriptor.parseMethod(BytecodeDescriptor.java:63)
        at sun.invoke.util.BytecodeDescriptor.parseMethod(BytecodeDescriptor.java:41)
        at java.lang.invoke.MethodType.fromMethodDescriptorString(MethodType.java:1067)
        at com.google.devtools.build.android.desugar.LambdaDesugaring$InvokedynamicRewriter.visitInvokeDynamicInsn(LambdaDesugaring.java:399)
        at org.objectweb.asm.MethodVisitor.visitInvokeDynamicInsn(Unknown Source)
        at org.objectweb.asm.MethodVisitor.visitInvokeDynamicInsn(Unknown Source)

```

[docu]: https://docs.gradle.org/current/userguide/java_library_plugin.html#sec:java_library_separation