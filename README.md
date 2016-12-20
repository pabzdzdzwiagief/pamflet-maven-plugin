# pamflet-maven-plugin

Pamflet generates documentation organized into short texts called "pamflets".
With this plugin you can use the generator in your Maven project.

For instructions on how to write pamflets read
[Pamflet's pamflet](http://www.foundweekends.org/pamflet/).
You can see some examples
[on this page](http://www.foundweekends.org/pamflet/Who%E2%80%99s+Using+Pamflet%3F.html).

## Usage
There is no need to install anything in your system - Pamflet is a pure Java
(well, pure Scala) tool, so Maven will download all necessary dependencies
for you.

As for the plugin itself, it is not available in Maven Central yet, so for now
to use it you need to install it locally:

    $ git clone https://github.com/pabzdzdzwiagief/pamflet-maven-plugin.git
    $ mvn install

Then include it as a plugin in your project's POM:

    <project>
        ...
        <build>
            ...
            <plugins>
                ...
                <plugin>
                    <groupId>com.github.pabadzdzwiagief</groupId>
                    <artifactId>pamflet-maven-plugin</artifactId>
                    <version>0.1.0-SNAPSHOT</version>
                    <!-- Use this to change directories used by the plugin -->
                    <configuration>
                        <!-- src/site by default -->
                        <baseSourceDirectory>src/alternative/location</baseSourceDirectory>
                        <!-- ${project.build.directory}/site by default -->
                        <outputDirectory>target/alternative/location</outputDirectory>
                    </configuration>
                    <!-- Use this to attach the plugin to a Lifecycle phase -->
                    <executions>
                        <execution>
                            <id>pamflet</id>
                            <!-- Phase during which to execute the plugin -->
                            <phase>package</phase>
                            <goals>
                                <goal>generate</goal>
                            </goals>
                        </execution>        
                    </executions>
                    <!-- Use this if you prefer a different Pamflet version -->
                    <dependencies>
                        <dependency>
                            <groupId>net.databinder</groupId>
                            <artifactId>pamflet-app_2.10</artifactId>
                            <version>0.6.0</version>
                        </dependency>
                    </dependencies>
                </plugin>
                ...
            </plugins>
            ...
        </build>
        ...
    </project>

To preview documentation in a browser run:

    $ mvn pamflet:preview

To generate documentation to `target/site/` directory run:

    $ mvn pamflet:generate


## License

LGPLv3, same as Pamflet's
