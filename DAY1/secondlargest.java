public class secondlargest {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4};
        int secondlargest = findSecondLargest(arr);
        System.out.println("Second largest number is: " + secondlargest);
    }

    public static int findSecondLargest(int[] arr) {
        int largest = -1;int seclargest=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                seclargest=largest;
                largest=arr[i];
            }
               else if(arr[i]>seclargest && arr[i]!=largest)
                {
                    seclargest = arr[i];
                }
            }
            
        
        return seclargest;
    }
    
}

