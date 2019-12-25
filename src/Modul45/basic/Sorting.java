//    package basic;
//
//    public class Sorting {
//        static void insertionSort(int [] arr){
//            int i, j;
//            int key;
//            for(i = 1; i<arr.length; i++){
//                j = i-1;
//                key = arr[i];
//                while(j >= 0 && arr[j] > key){
//                    arr[j+1] = arr[j];
//                    j--;
//                }
//                arr[j+1] = key;
//            }
//        }
//        static void insertionSort(LinkedList list){
//            node i = list.head.next;
//            node j;
//            int key;
//            while(i != null){
//                key = i.data;
//                j = i.prev;
//                while(j != null && j.data > key){
//                    j.next.data = j.data;
//                    j = j.prev;
//                }
//                if(j == null){
//                    list.head.data = key;
//                }else{
//                    j.next.data = key;
//                }
//                i = i.next;
//            }
//        }
//        static void bubbleSort(int [] arr){
//            for(int i = 0; i<arr.length; i++){
//                for(int j = i+1; j<(arr.length); j++){
//                    if(arr[i] > arr[j]){
//                        int tmp = arr[i];
//                        arr[i] = arr[j];
//                        arr[j] = tmp;
//                    }
//                }
//            }
//        }
//        static  void bubbleSort(LinkedList list){
//            node i = list.head;
//            node j;
//            while(i != null){
//                j = i.next;
//                while(j != null){
//                    if(i.data > j.data){
//                        int tmp = i.data;
//                        i.data = j.data;
//                        j.data = tmp;
//                    }
//                    j = j.next;
//                }
//                i = i.next;
//            }
//        }
//        static void selectionSort(int [] arr){
//            int i,j,index = 0;
//            for(i = arr.length-1; i>=0; i--){
//                int min = Integer.MAX_VALUE;
//                for(j = i; j>=0; j--){
//                    if(arr[j]<min){
//                        min = arr[j];
//                        index = j;
//                    }
//                }
//                int tmp = arr[index];
//                arr[index]=arr[i];
//                arr[i] = tmp;
//            }
//        }
//        static void selectionSort(LinkedList list){
//            node bantu = list.head;
//            node bantu2;
//            while(bantu != null){
//                int min = Integer.MAX_VALUE;
//                bantu2 = bantu;
//                node sign = bantu2;
//                while (bantu2 != null){
//                    if(bantu2.data < min){
//                        min = bantu2.data;
//                        sign = bantu2;
//                    }
//                    bantu2 = bantu2.next;
//                }
//                int tmp = sign.data;
//                sign.data = bantu.data;
//                bantu.data = tmp;
//                bantu= bantu.next;
//            }
//        }
//
//
//        static void mergeSort(int [] arr){
//            mergeSort(arr, new int[arr.length] ,0,arr.length-1);
//
//        }
//        static void mergeSort(int[] arr, int [] tmp, int leftstart, int rightend){
//            if(leftstart >= rightend){
//                return;
//            }
//            int mid = (leftstart + rightend)/2;
//            mergeSort(arr,tmp,leftstart,mid-1);
//            mergeSort(arr,tmp,mid+1,rightend);
//            mergeHalves(arr,tmp,leftstart,rightend);
//        }
//        static void mergeHalves(int [] arr, int [] tmp, int leftstart, int rightend){
//            int leftend = (leftstart + rightend)/2;
//            int rightstart = leftend +1;
//            int left = leftstart;
//            int right = rightstart;
//            int index = leftstart;
//            while(left <= leftend && right <= rightend){
////                System.out.println(arr[left] +  " vs " + arr[right]);
//                if(arr[left] <= arr[right]){
//                    tmp[index] = arr[left];
//                    left++;
//                }else{
//                    tmp[index] = arr[right];
//                    right++;
//                }
//                index++;
//            }
//            while(left <=leftend){
//                tmp[index] = arr[left];
//                left++; index++;
//            }
//            while(right <=rightend){
//                tmp[index] = arr[right];
//                right++; index++;
//            }
//            while(leftstart <= rightend){
//                arr[leftstart] = tmp[leftstart];
//                leftstart++;
//            }
//        }
//        static void displayArray(int [] arr){
//            for(int i  = 0; i<arr.length; i++){
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//        }
//        static void quickSort(int [] arr){
//            quick(arr,0,arr.length-1);
//        }
//        static void quick(int [] arr, int start, int end){
//            if(start >= end) return;
//            int pIndex = partition(arr,start,end);
//            quick(arr,start,pIndex-1);
//            quick(arr,pIndex+1,end);
//        }
//
//        static int partition(int [] arr, int start, int end){
//            int p = arr[end];
//            int pIndex = start;
//            for(int i = start; i<=end-1; i++){
//                if(arr[i] <= p){
//                    int tmp = arr[i];
//                    arr[i]= arr[pIndex];
//                    arr[pIndex] = tmp;
//                    pIndex++;
//                }
//            }
//            int tmp = arr[end];
//            arr[end]= arr[pIndex];
//            arr[pIndex] = tmp;
//            return pIndex;
//        }
//        public static void main(String[] args) {
//            int [] arr = {10,2,13,11,5,7,10};
//            int [] arr2 = arr;
//            System.out.println("\n===== Data Awal =====");
//            displayArray(arr);
//            System.out.println("\n===== Merge Sort  =====");
//            mergeSort(arr2);
//
//            System.out.println("\n===== Data Awal =====");
//            displayArray(arr);
//            System.out.println("\n===== Quick Sort  =====");
//            quickSort(arr);
//            displayArray(arr);
//        }
//
//    }
