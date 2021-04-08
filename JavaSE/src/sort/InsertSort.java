package sort;

public class InsertSort {
    public static void main(String[] args) {
        int a[] = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        InsertSort i = new InsertSort();
        int[] ints = i.insertSort(a);
        for (int i1 : ints) {
            System.out.print(i1 + " ");
        }

        int[] ints1 = i.insert(a);
        for (int i1 : ints) {
            System.out.print(i1 + " ");
        }
    }


    public int[] insertSort(int a[]) {
        int target = 0;
        for (int i = 0; i < a.length - 1; i++) {
            ok:
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    target = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = target;
                } else {
                    break ok;
                }
            }
        }
        return a;
    }

    //第二种实现方式
    public int[] insert(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
