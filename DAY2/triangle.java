public class triangle {
    public static void main(String[] args) {
        int[] arr = {5,6,9};
        if(isValid(arr)){
            System.out.println("Valid Triangle");
        }
        else{
            System.out.println("Invalid Triangle");
        }
    }
public static boolean isValid(int[] arr){
        if(arr[0]+arr[1]>arr[2] && arr[1]+arr[2]>arr[0] && arr[0]+arr[2]>arr[1]){
        return true;
        }
        else{
            return false;
        }
    }
}

  


