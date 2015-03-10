/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.guutong.chapter4.OP;
import com.guutong.chapter4.Patient;
import com.guutong.chapter4.IP;
import com.guutong.chapter4.YesNo;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GuutonG
 */
public class SumAvgReflectionPatientT {

    private float average(Patient patient) throws Exception {
        return (float) sum((IP) patient) / (float) count(patient);
    }

    private int count(Patient ip) throws Exception {
        Method[] methods = ip.getClass().getMethods();
        int count = 0;
        for (Method method : methods) {
            if (method.getName().startsWith("getRole")) {
                YesNo yn = (YesNo) method.invoke(ip);
                count = count + 1;
            }
        }
        return count;
    }

    public int sum(IP ip) throws Exception {
        int sum = 0;
        Method[] methods = ip.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("getRole")) {
                YesNo yn = (YesNo) method.invoke(ip);
                sum = sum + yn.getScore();
            }
        }
        return sum;
    }

    public int sum(OP op) throws Exception {
        int sum = 0;
        Method[] methods = op.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("getRole")) {
                YesNo yn = (YesNo) method.invoke(op);
                sum = sum + yn.getScore();
            }
        }
        return sum;
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testSumIP1() throws Exception {
        IP ip = new IP();
        ip.setRole1(YesNo.YES);
        ip.setRole2(YesNo.YES);
        ip.setRole3(YesNo.NO);
        ip.setRole4(YesNo.NO);
        ip.setRole5(YesNo.YES);

        assertEquals(3, sum(ip));
        assertEquals(0.6, average(ip), 0.05);

    }

    @Test
    public void testSumIP2() throws Exception {
        IP ip = new IP();
        ip.setRole1(YesNo.YES);
        ip.setRole2(YesNo.YES);
        ip.setRole3(YesNo.YES);
        ip.setRole4(YesNo.YES);
        ip.setRole5(YesNo.YES);

        assertEquals(5, sum(ip));
        assertEquals(1, average(ip), 0);
    }

    @Test
    public void testSumIP3() throws Exception {
        IP ip = new IP();
        ip.setRole1(YesNo.YES);
        ip.setRole2(YesNo.YES);
        ip.setRole3(YesNo.NO);
        ip.setRole4(YesNo.YES);
        ip.setRole5(YesNo.NO);

        assertEquals(3, sum(ip));
        assertEquals(0.6, average(ip), 0.05);
    }

    @Test
    public void testSumIP4() throws Exception {
        IP ip = new IP();
        ip.setRole1(YesNo.YES);
        ip.setRole2(YesNo.NO);
        ip.setRole3(YesNo.YES);
        ip.setRole4(YesNo.YES);
        ip.setRole5(YesNo.NO);

        assertEquals(3, sum(ip));
        assertEquals(0.6, average(ip), 0.05);
    }

    @Test
    public void testSumIP5() throws Exception {
        IP ip = new IP();
        ip.setRole1(YesNo.NO);
        ip.setRole2(YesNo.YES);
        ip.setRole3(YesNo.NO);
        ip.setRole4(YesNo.NO);
        ip.setRole5(YesNo.YES);

        assertEquals(2, sum(ip));
        assertEquals(0.4, average(ip), 0.05);
    }

}