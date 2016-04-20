================== Commands to run via terminal ==================
# Move to central directory. Example, 'cd ~/TrabalhoFinal/TrabalhoFinal/src/com/senac'.
# Compile all .java files. Starts at current directory. '-encoding iso-8859-1' is optional, it define files encoding.
javac -encoding iso-8859-1 -d ./bin $(find . -name "*.java")

# After run the project, remove all .class files.
rm -rf /bin
