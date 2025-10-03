package pers.cc.demo.leetcode.util;


import java.io.IOException;
import java.nio.file.*;

public class FileUtil {

        public static long countFile() throws IOException {
            Path folder = Paths.get("."); // 当前文件夹
            long count = Files.list(folder)
                    .filter(Files::isRegularFile) // 只统计文件
                    .count();
            System.out.println("当前文件夹下文件数量: " + count);
            return count;
    }

}
