javac -target 1.6 -source 1.4 com\ximpleware\*.java
javac -target 1.6 -source 1.4 com\ximpleware\xpath\*.java
javac -target 1.6 -source 1.4 com\ximpleware\parser\*.java
javac -target 1.6 -source 1.4 com\ximpleware\transcode\*.java
javac -target 1.6 -source 1.4 com\ximpleware\extended\*.java
javac -target 1.6 -source 1.4 com\ximpleware\extended\xpath\*.java
javac -target 1.6 -source 1.4 com\ximpleware\extended\parser\*.java
javac -target 1.6 -source 1.4 java_cup\*.java
javac -target 1.6 -source 1.4 java_cup\runtime\*.java

jar -cvf vtd-xml.jar com\ximpleware\*.class com\ximpleware\xpath\*.class com\ximpleware\parser\*.class com\ximpleware\transcode\*.class java_cup\*.class java_cup\runtime\*.class com\ximpleware\extended\*.class com\ximpleware\extended\xpath\*.class com\ximpleware\extended\parser\*.class

del/S *.class
