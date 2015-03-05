Scala getting started project
====

How to configure Maven to build scala projects
---

1) Add repositories

    <repositories>
        <repository>
            <id>Akka repository</id>
            <url>http://repo.akka.io/releases</url>
        </repository>
        <repository>
            <id>scala-tools.org</id>
            <name>Scala-tools Maven2 Repository</name>
            <url>http://scala-tools.org/repo-releases</url>
        </repository>
    </repositories>

2) Add plugin repositories

    <pluginRepositories>
        <pluginRepository>
            <id>scala-tools.org</id>
            <name>Scala-tools Maven2 Repository</name>
            <url>http://scala-tools.org/repo-releases</url>
        </pluginRepository>
    </pluginRepositories>

3) Dependency

    <dependencies>
    . . . 
        <dependency>
            <groupId>org.scala-lang</groupId>
            <artifactId>scala-library</artifactId>
            <version>2.11.1</version>
        </dependency>
    . . . 
    </dependencies>

4) Build section

    <build>
        <plugins>
    . . . 
            <plugin>
                <groupId>org.scala-tools</groupId>
                <artifactId>maven-scala-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>compile</goal>
                             <goal>testCompile</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <sourceDir>src/main/scala</sourceDir>
                    <jvmArgs>
                        <jvmArg>-Xms64m</jvmArg>
                        <jvmArg>-Xmx1024m</jvmArg>
                    </jvmArgs>
                </configuration>
            </plugin>
    . . . 
        </plugins>
    </build>
