LIB_DIR="./build/libs"

CLASSPATH=""
for filepath in "${LIB_DIR}"/*; do
  CLASSPATH="${CLASSPATH}:${filepath}"
done

java -cp "${CLASSPATH}" org.cyrilou.java_plugin_gradle.core.App
