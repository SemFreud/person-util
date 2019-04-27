package com.amber.dev.shell;

import com.amber.dev.utils.ProjectConstant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
     * @param reader
     * @return
     * @throws IOException
     */
    private String shellOutPut(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        String line ;
        int count =0 ;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\r\n");
            count++;
        }
        System.out.println(count);
        return result.toString();
    }

    /**
     * 匹配文件包含的值
     *
     * @param path 绝对路径
     * @param key  需要匹配的值
     * @return 返回匹配结果
     */
    public abstract String compareFileContent(String path, String key);

    /**
     * 获取resource下shell目录
     * @return shell目录
     */
    protected String getShellFilePath(){
        return ProjectConstant.SHELLS_PATH;
    }

}
