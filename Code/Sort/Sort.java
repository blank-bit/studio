import java.util.ArrayList;

/*********************************************
 * @Author : Mr.Wang
 * @Date : 2020-12-17 13:55:57
 @FilePath     : /Code/Sort/Sort.java
 * @Description : 排序算法
 *********************************************/
public class Sort {

    /*********************************************
     * @Description: 直接插入排序
     * @param {int[]} r
     * @return {*}
     *********************************************/
    public int[] InsSort(int[] r) {
        for (int i = 1; i < r.length; i++) {
            int temp = r[i], j;
            for (j = i - 1; temp < r[j] && j >= 0; j--)
                r[j + 1] = r[j];
            r[j + 1] = temp;
        }
        return r;
    }

    /*********************************************
     * @Description: 折半插入排序
     * @param {int[]} r
     * @return {*}
     *********************************************/
    public int[] BinSort(int[] r) {
        int j, low, mid, high, temp;
        for (int i = 1; i < r.length; i++) {
            temp = r[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (temp < r[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (j = i - 1; j >= low; j--)
                r[j + 1] = r[j];
            r[low] = temp;
        }

        return r;
    }

    /*********************************************
     * @Description: 希尔排序
     * @param {int[]} r
     * @return {*}
     *********************************************/
    public int[] ShellSort(int[] r) {
        int temp, delta, i, j;
        for (delta = r.length / 2; delta > 0; delta /= 2) {
            for (i = delta; i < r.length; i++) {
                temp = r[i];
                for (j = i - delta; j >= 0 && temp < r[j]; j -= delta) {
                    r[j + delta] = r[j];
                }
                r[j + delta] = temp;
            }
        }
        return r;
    }

    /*********************************************
     * @Description: 冒泡排序
     * @param {int[]} r
     * @return {*}
     *********************************************/
    public int[] BubbleSort(int[] r) {
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r.length - i - 1; j++) {
                if (r[j] > r[j + 1]) {
                    int temp = r[j + 1];
                    r[j + 1] = r[j];
                    r[j] = temp;
                }
            }
        }
        return r;
    }

    /*********************************************
     * @Description: 快速排序
     * @param {int[],int,int} r,low,high
     * @return {*}
     *********************************************/
    public void QkSort(int[] r, int low, int high) {
        if (low < high) {
            int left = low;
            int right = high;
            int temp = r[left];// 选基准记录
            while (left < right) {
                while (left < right && r[right] > temp)
                    right--;
                r[left] = r[right];// 小数换到左边

                while (left < right && r[left] < temp)
                    left++;
                r[right] = r[left];// 大数换到右边
                r[left] = temp;
            }

            QkSort(r, low, left - 1);
            QkSort(r, left + 1, high);
        }
    }

    /*********************************************
     * @Description: 选择排序
     * @param {int[]} r
     * @return {*}
     *********************************************/
    public int[] SelectSort(int[] r) {
        int i, j, k;
        for (i = 0; i < r.length - 1; i++) {
            k = i;
            for (j = i + 1; j < r.length; j++)
                if (r[j] < r[k])
                    k = j;
            if (i != k) {
                int temp = r[k];
                r[k] = r[i];
                r[i] = temp;
            }
        }
        return r;
    }

    /*********************************************
     * @Description: 堆排序
     * @param {int[]} r
     * @return {*}
     *********************************************/
    public void sift(int[] r, int i, int len) {
        int temp = r[i];// 以i为根结点开始筛选
        for (int j = i * 2 + 1; j < len; j = 2 * j + 1) {// 2*i+1取得左孩子
            if (j + 1 < len && r[j] < r[j + 1])// 若存在右子树且右子树根结点大，则沿右子树筛选
                j++;
            if (temp < r[j]) {
                r[i] = r[j];
                i = j;
            }
        }
        r[i] = temp;
    }

    public int[] crtheep(int[] r, int len) {
        for (int i = (len - 2) / 2; i >= 0; i--)// 从最后一个非叶结点开始调整
            sift(r, i, len);
        return r;
    }

    public int[] HeepSort(int[] r) {
        for (int i = r.length; i > 0; i--) {// 最后两个排完即可
            r = crtheep(r, i);// 取出最大值后重建堆
            int temp = r[0];
            r[0] = r[i - 1];
            r[i - 1] = temp;
        }
        return r;
    }

    /*********************************************
     * @Description: 归并排序
     * @param {int[],int,int} r,low,high
     * @return {*}
     *********************************************/
    public void Merge(int[] r, int low, int mid, int high) {
        int[] s = new int[high - low + 1];
        int i, j, k;
        i = low;
        j = mid + 1;
        k = 0;
        while (i <= mid && j <= high) {
            if (r[i] < r[j]) {
                s[k++] = r[i++];
            } else {
                s[k++] = r[j++];
            }
        }
        while (i <= mid) {
            s[k++] = r[i++];
        }
        while (j <= high) {
            s[k++] = r[j++];
        }

        for (int t = 0; t < s.length; t++)// 排好的有序段覆盖无序段
            r[low + t] = s[t];
    }

    public int[] MergeSort(int[] r, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSort(r, low, mid);
            MergeSort(r, mid + 1, high);
            Merge(r, low, mid, high);
        }
        return r;
    }

    /*********************************************
     * @Description: 基数排序
     * @param {int[]} r
     * @return {*}
     *********************************************/
    public void BaseSort(int[] r) {
        ArrayList<ArrayList<Integer>> queue1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue2 = new ArrayList<>();
            queue1.add(queue2);// 创建0-9的基数，每个基数上都是一个数组
        }

        int max = r[0];// 找到最大值
        for (int i = 0; i < r.length; i++) {
            if (r[i] > max)
                max = r[i];
        }

        int times = 0;// 标记最大值位数
        while (max > 0) {
            max /= 10;
            times++;
        }

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < r.length; j++) {
                int x = (int) (r[j] %  Math.pow(10, i + 1) / Math.pow(10, i));// 取某一个位数(个位、十位、百位)-->先模运算取余数，再除取商
                ArrayList<Integer> queue3 = queue1.get(x);
                queue3.add(r[j]);
                queue1.set(x, queue3);
            }

            int count = 0;
            for (int k = 0; k < 10; k++) {
                while (queue1.get(k).size() > 0) {// 将每一个基数数组的数据按顺序更新到r中
                    ArrayList<Integer> queue4 = queue1.get(k);
                    r[count] = queue4.get(0);
                    queue4.remove(0);
                    count++;
                }
            }
        }
    }

    public static void main(String args[]) {

        int[] r = { 1, 34, 65, 32, 86, 45, 64, 78 };
        Sort sort = new Sort();

        // sort.InsSort(r);
        // System.out.print("直接插入排序：");
        // for (int i = 0; i < r.length; i++)
        // System.out.print(r[i] + " ");
        // System.out.println();

        // sort.BinSort(r);
        // System.out.print("折半插入排序：");
        // for (int i = 0; i < r.length; i++)
        // System.out.print(r[i] + " ");
        // System.out.println();

        // sort.ShellSort(r);
        // System.out.print("希尔排序：");
        // for (int i = 0; i < r.length; i++)
        // System.out.print(r[i] + " ");
        // System.out.println();

        // sort.BubbleSort(r);
        // System.out.print("冒泡排序：");
        // for (int i = 0; i < r.length; i++)
        // System.out.print(r[i] + " ");
        // System.out.println();

        // sort.QkSort(r, 0, r.length - 1);
        // System.out.print("快速排序：");
        // for (int i = 0; i < r.length; i++)
        // System.out.print(r[i] + " ");
        // System.out.println();

        // sort.SelectSort(r);
        // System.out.print("选择排序：");
        // for (int i = 0; i < r.length; i++)
        // System.out.print(r[i] + " ");
        // System.out.println();

        // sort.HeepSort(r);
        // System.out.print("堆排序：");
        // for (int i = 0; i < r.length; i++)
        // System.out.print(r[i] + " ");
        // System.out.println();

        // sort.MergeSort(r, 0, r.length - 1);
        // System.out.print("归并排序：");
        // for (int i = 0; i < r.length; i++)
        // System.out.print(r[i] + " ");
        // System.out.println();

        sort.BaseSort(r);
        System.out.print("基数排序：");
        for (int i = 0; i < r.length; i++)
            System.out.print(r[i] + " ");
        System.out.println();
    }
}