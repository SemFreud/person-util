package com.amber.dev.shell;

import com.amber.dev.utils.ProjectConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SemFreud
 * @createTime 2019-04-27 08:34
 */
public class LinuxShellProcess extends AbstractShellProcess {

    @Override
    protected String getOsName() {
        return "linux";
    }

    @Override
    public String compareFileContent(String path, String key) {
        List<String> commands = new ArrayList<String>();
        commands.add("sh");
        commands.add(getShellFilePath() + getOsName() + "/" + ProjectConstant.COMPARE_FILE_CONTENT);
        commands.add(path);
        commands.add(key);
        System.out.println(commands);
        return execShell(commands);
    }



}
