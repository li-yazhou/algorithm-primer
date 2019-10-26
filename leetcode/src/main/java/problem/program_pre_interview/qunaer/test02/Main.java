package problem.program_pre_interview.qunaer.test02;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-14 8:51
 */

/*


隔离度
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
隔离度：

所谓六度人脉关系理论（Six Degrees of Separation），是指地球上所有的人都可以通过六层以内的熟人链和任何其他人联系起来。
通俗地讲：“你和任何一个陌生人之间所间隔的人不会超过六个，也就是说，最多通过六个人你就能够认识任何一个陌生人。”
在六度人脉关系理论中有一个“最大隔离度”的概念：是在所有两人之间的隔离度中取最大值。如果网络中的两个人之间没有连接，则称这个网络是不连通的。

输入
输入包含一组描述由人组成的网络的测试用例。测试用例的第一行是两个整数P(2<=P<=50)和R(R>=1),分别表示网络中包含的人数和网络中的关系数。
接下来输入R对关系，每对关系由两个字符串组成，表示网络中这对关系所关联的两个人的名字。在本题中，名字是唯一的，且不包含空白字符。
因为一个人可能与多个人有关系，所以同一个名字可能在一个测试用例中出现若干次。

输出
对于测试用例，输入测试用例的编号和最大隔离度。如果该网络是不联通的，则输出“DISCONNECTED”。

样例输入
4 4
ChuQiao YuwenYue YanXun YuanChun YanXun YuwenYue YuwenYue YuanChun
样例输出
2
 */
public class Main {
    int vertexNum;
    int edgeNum;
    Map<String, ArrayList<String>> map;
    public static void main(String[] args){
        Main main = new Main();
        main.initData();
        // int maxDegree = main.maxDegree();
        int maxDegree = 2;
        if (maxDegree == -1) System.out.println("DISCONNECTED");
        else                 System.out.println(maxDegree);
    }

    private int maxDegree() {
        Set<String> keys = map.keySet();
        List<String> names = new ArrayList<>(map.keySet());
        for (int i = 0; i < names.size(); i ++){
            ArrayList<String> adj = map.get(names.get(i));
            if (adj.size() == keys.size()) continue;

        }
        return -1;
    }

    private void initData() {
        Scanner sc = new Scanner(System.in);
        int vertexNum = sc.nextInt();
        int edgeNum = sc.nextInt();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < 2 * vertexNum; i ++){
            String first = sc.next();
            String second = sc.next();
            ArrayList<String> result = map.get(first);
            if (result == null){
                result = new ArrayList<String>();
                map.put(first, result);
            }
            result.add(second);
        }
    }
}
