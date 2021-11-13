import java.awt.*;
import java.util.Scanner;

/**
 * Project name(项目名称)：算法_二分搜索法求平方根
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/13
 * Time(创建时间)： 21:43
 * Version(版本): 1.0
 * Description(描述)：
 * 使用二分查找，实现int mySqrt(int x)函数，求平方根的功能。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 测试输入：4
 * <p>
 * 预期输出：2
 * <p>
 * 样例2：
 * <p>
 * 测试输入：8
 * <p>
 * 预期输出：2
 * <p>
 * 解释：8 的平方根是 2.82842...,  由于返回类型是整数，小数部分将被舍去。
 */

public class test
{
    public int mySqrt(int x)
    {
        /********* Begin *********/
        if (x <= 1)          //0和1没必要计算，直接返回退出，负数无法计算也无法进入方法参数内
        {
            return x;
        }
        int low = 1;     //低位
        int high = x;     //高位
        int mid;          //中位，low + (high - low) / 2
        while (low <= high)   //退出条件在low>high
        {
            mid = low + (high - low) / 2;
            int sqrt = x / mid;      //计算的平方根
            if (sqrt == mid)          //刚好在中间，返回
            {
                return mid;
            }
            else if (sqrt < mid)      //在左边
            {
                high = mid - 1;
            }
            else                      //在右边
            {
                low = mid + 1;
            }
        }
        return high;
        /********* End *********/
    }

    public static void main(String[] args)
    {
        int number = 0;
        Scanner input = new Scanner(System.in);
        //控制台输入变量:number
        int errCount = 0;
        while (true)
        {
            try
            {
                //min:0
                //max:1000000000
                System.out.print("请输入：");
                number = input.nextInt();
                if (number >= 0 && number <= 1000000000)
                {
                    break;
                }
                else
                {
                    errCount++;
                    Toolkit.getDefaultToolkit().beep();
                    if (errCount > 10)
                    {
                        System.err.println("错误次数过多！！！退出");
                        System.exit(1);
                    }
                    System.out.println("输入的数据不在范围内! 范围：[0,1000000000]");
                }
            }
            catch (Exception e)
            {
                errCount++;
                if (errCount > 5)
                {
                    Toolkit.getDefaultToolkit().beep();
                    System.err.println("错误次数过多！！！退出");
                    System.exit(1);
                }
                else
                {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("输入错误！！！请重新输入！");
                    input.nextLine();
                }
            }
        }
        test t = new test();
        System.out.println(number + "的平方根是：" + t.mySqrt(number));
    }
}
