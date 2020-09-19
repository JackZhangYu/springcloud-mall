package com.mall.client.service.impl;

import java.util.Scanner;

/**
 * @author cheng
 * @date 2020/6/10 16:12
 */
public class SelectStu {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String stu = scanner.nextLine();

        String username = "李红";
        switch (username){
            case "李红":
                System.out.println("年龄使用正确");
        }
        scanner.close();
    }

}