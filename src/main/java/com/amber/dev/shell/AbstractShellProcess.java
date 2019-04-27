package com.amber.dev.shell;

import com.amber.dev.utils.ProjectConstant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SemFreud
 * @createTime 2019-04-27 08:28
 */
public abstract class AbstractShellProcess {
    /**
     * 获取系统版本
     * @return
     */
    protected abstract String getOsName();

    /**
     * 通过脚本名和环境变量执行方法
     * @param shellName 脚本名
     * @param environment 环境变量
     * @return
     */
    public String execShell(String shellName , String[] environment){
        List<String> commands = new ArrayList<String>();
        commands.add("sh");
        commands.add(getShellFilePath() + getOsName() + "/" + shellName);
        commands.addAll(Arrays.asList(environment));
        return execShell(commands);
    }

    /**
     * 通过命令执行 ， 可包含环境变量
     * @param commands 命令
     * @return
     */
    public String execShell(List<String> commands) {
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return shellOutPut(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回命令执行后的输出结果
     *
     * @param reader 输出流
     * @return
     * @throws IOException
     */
    private String shellOutPut(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        String line ;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\r\n");
        }
        return result.toString();
    }

    /**
     * 匹配文件包含的值
     *
     * @param path 文件绝对路径
     * @param key  需要匹配的值
     * @return 返回匹配结果
     */
    public String compareFileContent(String path, String key){
        return execShell(ProjectConstant.COMPARE_FILE_CONTENT , new String[]{path,key});
    }
    /**
     * 获取resource下shell目录
     * @return shell目录
     */
    protected String getShellFilePath(){
        return ProjectConstant.SHELLS_PATH;
    }

}
