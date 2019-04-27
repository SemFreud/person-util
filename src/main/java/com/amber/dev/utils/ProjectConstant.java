package com.amber.dev.utils;

/**
 * @author SemFreud
 * @createTime 2019-04-27 09:03
 */
public class ProjectConstant {
    public static final String RESOURCE_PATH = ProjectConstant.class.getClassLoader().getResource("").getPath();
    public static final String SHELLS_PATH = RESOURCE_PATH + "shells/";
    public static final String COMPARE_FILE_CONTENT="compare_file_content.sh";
}
