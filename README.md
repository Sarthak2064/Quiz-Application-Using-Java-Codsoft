# Quiz-Application-Using-Java-Codsoft

# Number-Game-Codsoft

### Prerequisites:
1. **Java Development Kit (JDK):** Ensure you have JDK installed on your system. You can download it from the Oracle website or use OpenJDK, an open-source alternative.

2. **Set Up Environment Variables:** Set the `JAVA_HOME` environment variable to point to your JDK installation directory and add the JDK's `bin` directory to the system's PATH variable. Refer to the earlier explanation about setting up Java environment variables.

### Steps to Run a Java Program from GitHub:

1. **Clone or Download the Repository:**
   - Go to the GitHub repository containing the Java program.
   - Click on the "Code" or "Download" button and select "Download ZIP" to download the repository as a ZIP file.
   - Alternatively, if you have Git installed, you can use the `git clone` command to clone the repository to your local machine:
     ```
     git clone <repository_URL>
     ```
   Replace `<repository_URL>` with the actual URL of the GitHub repository.

2. **Extract the Downloaded ZIP (If applicable):**
   - If you downloaded a ZIP file, extract its contents to a folder on your computer.

3. **Locate the Java Source File:**
   - Navigate to the folder where the Java source code (`*.java` file) is located within the downloaded/cloned repository.

4. **Compile the Java Program:**
   - Open a terminal or command prompt.
   - Navigate to the directory containing the Java source file using the `cd` command.
   - Compile the Java source file using `javac` (Java Compiler). For example:
     ```
     javac YourJavaProgram.java
     ```
   Replace `YourJavaProgram.java` with the name of the Java source file you want to compile.

5. **Run the Compiled Java Program:**
   - After successful compilation, a `.class` file (bytecode) is generated in the same directory.
   - Run the Java program using the `java` command followed by the class name (without the file extension). For example:
     ```
     java YourJavaProgram
     ```
   Replace `YourJavaProgram` with the name of the main class that contains the `public static void main(String[] args)` method.
