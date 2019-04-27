package com.amber.dev;

import com.amber.dev.shell.LinuxShellProcess;

/**
 * @author SemFreud
 * @createTime 2019-04-27 08:53
 */
public class Application {

    public static void main(String[] args) {
        LinuxShellProcess process = new LinuxShellProcess();
        String result= process.compareFileContent("/Users/amber/IdeaProjects/jeeidp/pom.xml","artifactId");
        System.out.println(result);
    }
}
