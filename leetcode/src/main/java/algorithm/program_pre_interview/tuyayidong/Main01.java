package algorithm.program_pre_interview.tuyayidong;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-05 13:33
 */
public class Main01 {

    public boolean checkIp0(String ip){
        boolean isValid = false;
        if (ip == null || ip.length() < 7 || ip.length() > 15) return isValid;

        String[] slices = ip.split("\\.");
        System.out.println(Arrays.toString(slices));
        if (slices.length != 4) return isValid;


        int num;
        for (String slice : slices){
             try{
                 num = Integer.parseInt(slice);
             } catch(NumberFormatException nfe) {
                 return isValid;
             }
            if (num < 0 || num > 255)
                return isValid;
        }
        return isValid;
    }


    public boolean checkIp(String ip){
        if (ip == null || ip.length() < 7 || ip.length() > 15) return false;
        String regex = "(([1-9]?\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}([1-9]?\\d|1\\d{2}|2[0-4]\\d|25[0-5])";
        return ip.matches(regex);
    }

    @Test
    public void test(){
        String[] ips = {
                "0.0.0.0",
                "255.255.255.255",
                "168.192.0.1",
                "0.168.192.1",
                "256.255.255.25",
                "00.168.192.1",
//                ".0.168.192.1",
//                "168.192.1",
//                "ip.168.192.1",
        };
        for (String ip : ips) System.out.println(ip + " :: " + checkIp(ip));
    }
}
