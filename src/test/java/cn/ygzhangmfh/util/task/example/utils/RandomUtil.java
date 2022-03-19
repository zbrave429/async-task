package cn.ygzhangmfh.util.task.example.utils;

import java.util.Random;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-01-09 23:11
 */
public class RandomUtil {

    public static int getRandomNum(int min, int max){
        return new Random().nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        System.out.println(getRandomNum(200, 500));
    }

}
