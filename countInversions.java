public class countInversions {
    public static void main(String[] args){
        int [] arr = {9,8,7,6,5,4,3,2,1};
        int n =arr.length;
        System.out.println(countInversionsUsingNestedLoops(arr,n));
        System.out.println("Using Merge Sort: "+countInversionsUsingMergeSort(arr,0,n-1));
    }

    private static int countInversionsUsingNestedLoops(int[] arr,int n) {
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static int countInversionsUsingMergeSort(int[] arr,int l,int r){
    if(l>=r){
        return 0;
    }
    int mid = (l+r)/2;
    int invCount = countInversionsUsingMergeSort(arr,l,mid);
    invCount += countInversionsUsingMergeSort(arr,mid+1,r);
    invCount += mergeAndCount(arr,l,mid,r);
    return invCount;
}
}
