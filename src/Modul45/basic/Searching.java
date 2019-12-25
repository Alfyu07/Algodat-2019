//package basic;
//
//public class Searching {
//    static int jumpSearch(int [] arr, int cari){
//        int step = (int ) Math.sqrt(arr.length);
//        int prev = 0;
//        while(step < arr.length && arr[step] < cari){
//            System.out.println(arr[step]);
//            if(arr[step] == cari) return step;
//            prev = step;
//            step+=(int )Math.sqrt(arr.length);
//        }
//        while(prev < arr.length){
//            System.out.println(" === " + arr[prev]);
//            if(arr[prev] == cari) return prev;
//            if(prev > step) return -1;
//            prev++;
//        }
//        return -1;
//    }
//    static int binarySearch(int [] arr, int cari){
//        return binarySearch(arr,cari,0,arr.length-1);
//    }
//    static int binarySearch(int [] arr, int cari, int low, int high){
//        int mid = (low + high)/2;
//        if( arr[mid] == cari){
//            return mid;
//        }
//        if(low == high && arr[mid] != cari) return -1;
//        if(cari > arr[mid]){
//            return binarySearch(arr,cari,mid+1,high);
//        }else if(cari < arr[mid]){
//            return binarySearch(arr,cari,low,mid-1);
//        }
//        return -2;
//    }
//    //self organizing , pindah data yang ketemu ke data paling depan.
//    static void displayArray(int [] arr){
//        for(int i  = 0; i<arr.length; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        int [] arr = { 0, 1, 2, 3, 5, 8, 13, 21,34, 55, 89, 144, 233, 377 };
//        LinkedList list = new LinkedList();
//        System.out.println((int) 3.7);
//        displayArray(arr);
//        System.out.println(jumpSearch(arr,55));
//        System.out.println(binarySearch(arr,5));
//    }
//}
