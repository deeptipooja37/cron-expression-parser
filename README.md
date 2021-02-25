# cron-expression-parser
Application parses a cron string and expands each field to show the times at which it will run. Project has been built using gradle and a wrapper is attached, you need not to has gradle installed on your system.

Steps to run the project-
1. Switch to the directory
      >cd cron-expression-parser/cron-expression-parser
2. Build the project
      >./gradlew build
4. Run the built jar with an argument
      >java -jar ./build/libs/cron-parser.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
      


