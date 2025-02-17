package BinarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer, stringTokenizer1;
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] data = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        for(int i=0;i<N;i++){
            data[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(data);


        int M = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        for(int i=0;i<M;i++){
            int key = Integer.parseInt(stringTokenizer1.nextToken());
            stringBuilder.append(upperBound(data,key)-lowerBound(data,key)).append(" ");
        }

        System.out.println(stringBuilder);

    }

    public static int lowerBound(int[] arr, int key){
        int start = 0;
        int end = arr.length;

        while(start<end){
            int mid = (start+end)/2;

            if(key<=arr[mid]){
                end=mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

    public static int upperBound(int[] arr, int key){
        int start = 0;
        int end = arr.length;

        while(start<end){
            int mid = (start+end)/2;

            if(key<arr[mid]){
                end=mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

}
