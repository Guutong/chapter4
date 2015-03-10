
import com.guutong.chapter4.IP;
import com.guutong.chapter4.YesNo;
import junit.framework.TestCase;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author GuutonG
 */
public class SumAveragePatientT extends TestCase {

    public int sum(IP ip) {
        return ip.getRole1().getScore()
                +ip.getRole2().getScore()
                +ip.getRole3().getScore()
                +ip.getRole4().getScore()
                +ip.getRole5().getScore();
    }
    
    public void sum1Test() {
        IP ip = new IP();
        ip.setRole1(YesNo.YES);
        ip.setRole2(YesNo.YES);
        ip.setRole3(YesNo.NO);
        ip.setRole4(YesNo.NO);
        ip.setRole5(YesNo.YES);

        assertEquals(3, sum(ip));
    }
}