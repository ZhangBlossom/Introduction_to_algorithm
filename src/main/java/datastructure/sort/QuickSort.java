package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/31 13:54
 * Description:
 */
public class QuickSort {
    /*
     * 快速排序 找到一个中轴 让中轴左边小于中轴 右边大于中轴
     * 然后把左边的再次按上面的方法进行
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        //pivot中轴值
        int pivot = arr[(left + right) / 2];
        //while循环是为了让左边小于pivot 右边大于pivot
        while (l < r) {//左下标还小于右下标
            while (arr[l] < pivot) {//在pivot左边一直找 直到找到的数据大于pivot退出
                l++;
            }//退出时arr[l]>=pivot
            while (arr[r] > pivot) {//在pivot右边一直找 直到找到比pivot小的退出
                r--;
            }//退出时arr[r]>pivot
            if (l >= r) {
                break;//如果按照上面的寻找方法使得l>=r说明左边的已经都小于pivot
                //右边的都大于pivot了
            }
            //如果没有成立 那么就交换此时的左值和右值 因为他们不合理
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            //交换后l指向arr[r] r指向arr[l]
            //如果交换后arr[l]==pivot 那么r--
            if (pivot == arr[l]) {//arr[l]==pivot说明之前是r指向了pivot 那么之后r继续左移
                r--;
            }
            if (pivot == arr[r]) {//反之右移
                l++;
            }
        }
        //如果l==r 必须l++和r-- 否则栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }


    public static int[] qsort(int arr[], int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            //当i和j两个指针停下的时候
            //arr[i]>=pivot的
            //arr[j]<=pivot的
            //如果相等那么让左指针继续++
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {//不相等说明arr[i]<arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = qsort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = qsort(arr, j + 1, end);
        }
        return (arr);
    }


    /**
     * 下面是对代码的逐步解释：
     * <p>
     * public static int[] quickSortX(int[] arr, int start, int end)：这是快速排序的入口函数，
     * 它接受一个整数数组 arr 以及排序范围的起始位置 start
     * 和结束位置 end 作为参数，并返回排序后的整数数组。
     * <p>
     * int pivot = arr[start];：选择数组中的第一个元素作为中轴值（pivot）。
     * <p>
     * int left = start; 和 int right = end;：定义两个指针，left 从左向右移动，right 从右向左移动，
     * 用于在数组中找到需要交换的元素。
     * <p>
     * 下面的 while (left < right) 循环是快速排序的核心部分，它在数组中找到需要交换的元素，
     * 以确保中轴值左边的元素都小于等于中轴值，中轴值右边的元素都大于等于中轴值。这个循环包含以下几个部分：
     * <p>
     * 第一个 while 循环：从左边开始，找到一个大于或等于中轴值的元素。
     * 第二个 while 循环：从右边开始，找到一个小于或等于中轴值的元素。
     * 如果找到的左边元素等于右边元素，则继续将 left 向右移动，以避免出现无限循环。
     * 否则，交换左边元素和右边元素的值，确保左边元素小于中轴值，右边元素大于中轴值。
     * 之后，代码检查是否有需要递归排序的左半部分和右半部分。如果左半部分的起始位置小于左指针的前一个位置，
     * 递归调用 quickSortX 对左半部分进行排序。同样，如果右半部分的结束位置大于右指针的后一个位置，递归调用
     * quickSortX 对右半部分进行排序。
     * <p>
     * 最后，函数返回排序后的数组 arr。
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSortX(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;
        //范围合法性
        while (left < right) {
            //设定pivot中轴值左边的数据要求比pivot小
            while (left < right && arr[left] < pivot) {
                left++;
            }
            //设定pivot中轴值右边的数据要比pivot大
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //循环停止时 存在  arr[right]<=pivot>=arr[left]
            //如果等于 那么继续让left指针后移一位
            if (left < right && arr[left] == arr[right]) {
                left++;
            } else {//否则就是直接交换他们两个的值即可
                //此时存在 arr[left]<pivot<arr[right]
                //交换数据
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        if (start < left - 1) {
            arr = quickSortX(arr, start, left - 1);
        }
        if (right + 1 < end) {
            arr = quickSortX(arr, right + 1, end);
        }
        return arr;
    }


    //---------------------超级复杂版本----------------------

    /**
     * void quickSort(int[] arr)：这是公共的快速排序入口函数。
     * 它接受一个整数数组 arr 并检查是否需要排序。如果数组为空或只包含一个元素，它就不执行排序。否则，它调用
     * quickSortO2 来进行快速排序。
     * <p>
     * void quickSortO2(int[] arr, int left, int right)：这个函数执行实际的快速排序算法。
     * 它接受数组 arr 以及排序的范围从 left 到
     * right。该函数使用了随机选择中轴值的方法，然后调用 partition 函数来划分数组，并递归地对左右两部分进行排序。
     * <p>
     * swap 函数用于交换数组中的两个元素。这个函数通过位运算进行交换，是一种非常快速的方法。
     * <p>
     * int[] partition(int[] arr, int left, int right)：这个函数用于处理 arr[left...right]
     * 上的数据，将数组按照中轴值进行划分。它返回一个包含两个元素的整数数组，
     * 表示等于中轴值的区域的左边界和右边界。这个函数采用双指针法，其中 lessBound
     * 表示小于区的右边界，moreBound 表示大于区的左边界。
     * <p>
     * 首先，通过将 arr[right] 作为中轴值，初始化 lessBound 和 moreBound。
     * 使用 left 指针从左到右遍历数组元素。
     * 如果当前元素小于中轴值，将其与 lessBound 右边的元素交换，并将 lessBound 和 left 向右移动。
     * 如果当前元素大于中轴值，将其与 moreBound 左边的元素交换，并将 moreBound 向左移动。
     * 如果当前元素等于中轴值，只将 left 指针向右移动。
     * 最后，将 arr[right] 与 moreBound 处的元素交换，将数组划分为小于、等于和大于中轴值的三个部分。
     * 返回 lessBound + 1 和 moreBound，它们分别表示等于区的左边界和右边界。
     * <p>
     * 这里，对于partition方法，我的实现和思考思路如下：
     * <p>
     * 初始化 lessBound 为 left - 1，即 lessBound 初始为-1，表示小于区的右边界。
     * <p>
     * 初始化 moreBound 为 right，即 moreBound 初始为10，表示大于区的左边界。
     * <p>
     * 使用 left 指针从左到右遍历数组元素。
     * <p>
     * 当 arr[left]（当前元素）小于 arr[right]（中轴值）时，执行以下操作：
     * 交换 arr[left] 和 arr[lessBound + 1]，然后增加 lessBound 和 left。
     * 这表示我们将小于区的右边界向右扩展一个位置，并将当前元素放入小于区。
     * 当 arr[left] 大于 arr[right] 时，执行以下操作：
     * 交换 arr[left] 和 arr[moreBound - 1]，然后减少 moreBound。
     * 这表示我们将大于区的左边界向左扩展一个位置，并将当前元素放入大于区。
     * 当 arr[left] 等于 arr[right] 时，只将 left 指针向右移动，因为相等的元素将留在等于区。
     * 最终，left 指针遍历整个数组，将数组划分为三个部分：小于区、等于区和大于区。
     * <p>
     * 为了完成划分，将 arr[right]（中轴值）与 arr[moreBound]（大于区的左边界）进行交换。这将把中轴值放到正确的位置。
     * <p>
     * 返回一个包含两个元素的数组，[lessBound + 1, moreBound]。这个数组表示等于区的左边界和右边界。
     * <p>
     * 其中，对于 arr[left] > arr[right] 这种情况，我并没有left++,是因为：
     * 当前元素 arr[left] 大于中轴值 arr[right] 时，我们将它放入大于区，即 arr[moreBound - 1] 处。
     * 这意味着 moreBound 表示大于区的左边界。
     * <p>
     * 通过减少 moreBound 的值，我们将大于区的左边界向左移动，同时保持 left 指针不变。
     * 这是因为当前元素 arr[left] 已经被放入大于区，而在下一次迭代中，我们需要继续检查新的 arr[left]
     * 是否大于中轴值，以确保大于区包含所有大于中轴值的元素。
     * <p>
     * 所以，left 指针只在当前元素小于中轴值时执行 ++ 操作，表示将当前元素放入小于区，而在当前元素大于中轴值时，
     * 只需要更新大于区的左边界 moreBound，而不需要改变 left 指针。
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSortO2(arr, 0, arr.length - 1);
    }

    public static void quickSortO2(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            quickSortO2(arr, left, p[0] - 1); //< 区域
            quickSortO2(arr, p[1] + 1, right); //> 区域
        }
    }

    //当前方法用于处理arr[left...right]上面的数据
    //默认以arr[right]做划分
    //返回等于区域（左边界、右边界），所以返回一个长度为2的数组res，res[0],res[1]
    public static int[] partition(int[] arr, int left, int right) {
        int lessBound = left - 1;//小于区右边界
        int moreBound = right; //大于区左边界
        while (left < moreBound) {//left表示当前数据的位置 arr[right] -->划分值
            if (arr[left] < arr[right]) { //当前数据小于划分值
                swap(arr, ++lessBound, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --moreBound, left);
            } else {
                left++;
            }
        }
        swap(arr, moreBound, right);
        return new int[]{lessBound + 1, moreBound};
    }

    public static void swap(int[] arr, int i, int j) {
        //特别注意 如果i==j，那么会导致数据被抹除
        if (i == j) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    //指定一个数据 然后比这个数据大的数据放在右边，比这个数据小于等于的放在左边。
    public static void smallLeftBigRight(int[] arr, int target) {
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (arr[fast] <= target) {
                arr[slow] ^= arr[fast];
                arr[fast] ^= arr[slow];
                arr[slow] ^= arr[fast];
                slow++;
            }
            fast++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 123, 5, 3425, 2130, -4365, -123};
        //smallLeftBigRight(arr,100);
        //quickSortX(arr, 0, arr.length - 1);
        //System.out.println(Arrays.toString(arr));
        //quickSort(arr);
        quickSortX(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
 