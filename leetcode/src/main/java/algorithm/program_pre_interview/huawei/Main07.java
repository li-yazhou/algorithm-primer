package algorithm.program_pre_interview.huawei;

import org.junit.Test;

import java.util.Scanner;


public class Main07 {
    

    public static void solution(String line) {
        int max_length = 0;
        String result = "";
        String[] arr = line.split("\\D+");
        if(arr.length == 0) {
            // System.out.println(result);
            System.out.println(max_length);
        	return ;
        }
        for(int i = 0; i < arr.length; i++) {
        	int temp = arr[i].length(); 
        	if(temp >= max_length) {
        		result = arr[i];
        		max_length = temp;
        	}
        }
        System.out.println(result);
        System.out.println(max_length);
    }


    @Test
    public void test(){
        String[] inputs = {
                "abcd12345ed125ss123058789",
                "abcd123ed12345ss123058789",
                "abcd123ed1234512305",
                "abcd123ed456789",
                "000abcd123ed456789",
                "abcd",
                "000000000000abcd123ed456789",
                ""
        };

        for (String s : inputs){
            System.out.println("--------------");
            System.out.println(s);
            solution(s);
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
        	String input = sc.nextLine();
            solution(input);
        }
        sc.close();
    }
    
}

