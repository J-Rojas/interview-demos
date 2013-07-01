/* 
Copyright 2013 Jose Rojas 
All rights reserved.   
*/

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class AutomobileSortTest {
    
    final Automobile HONDA = new Automobile("Honda", 20000, 35);
    final Automobile NISSAN = new Automobile("Nissan", 17000, 32);
    final Automobile ASTON = new Automobile("Aston Martin", 100000, 19);
    final Automobile SAAB = new Automobile("Saab", 30000, 28);
    final Automobile JEEP = new Automobile("Jeep", 23000, 17);
    final Automobile MERCEDES = new Automobile("Mercedes", 45000, 31);
    
    //note that the array elements are not in the correct order for any of the tests
    Collection<Automobile> autoArrays = Arrays.asList(
        HONDA,
        NISSAN,
        ASTON,
        SAAB,
        JEEP,
        MERCEDES
    );
    
    int len = autoArrays.size();
    
    @Test
    public void sortAutomobileByNameAsc() {
        List<Automobile> list = Automobile.Sorter.sort(autoArrays, "name", true);
        
        //verify the first, last, and size    
        Assert.assertEquals("arrays is not the correct size", list.size(), len);
        Assert.assertEquals("The first element name should be: Aston Martin, is " + list.get(0).name, list.get(0), ASTON);
        Assert.assertEquals("The last element name should be: Saab" + list.get(len - 1).name , list.get(len - 1), SAAB);        
    }
    
    public void sortAutomobileByNameDesc() {
        List<Automobile> list = Automobile.Sorter.sort(autoArrays, "name", false);
        
        //verify the first, last, and size
        Assert.assertEquals("arrays is not the correct size", list.size(), len);
        Assert.assertEquals("The first element name should be: Saab, is " + list.get(0).name, list.get(0), SAAB);
        Assert.assertEquals("The last element name should be: Aston Martin, is " + list.get(len - 1).name, list.get(len - 1).name , ASTON);        
    }
 
    @Test
    public void sortAutomobileByPriceAsc() {
        List<Automobile> list = Automobile.Sorter.sort(autoArrays, "price", true);
        
        //verify the first, last, and size
        Assert.assertEquals("arrays is not the correct size", list.size(), len);
        Assert.assertEquals("The first element name should be: Nissan, is " + list.get(0).name, list.get(0), NISSAN);
        Assert.assertEquals("The last element name should be: Aston Martin, is " + list.get(len - 1).name, list.get(5), ASTON);        
    }
    
    @Test
    public void sortAutomobileByPriceDesc() {
        List<Automobile> list = Automobile.Sorter.sort(autoArrays, "price", false);
        
        //verify the first, last, and size
        Assert.assertEquals("arrays is not the correct size", list.size(), len);
        Assert.assertEquals("The first element name should be: Aston Martin, is " + list.get(0).name, list.get(0), ASTON);
        Assert.assertEquals("The last element name should be: Nissan, is " + list.get(len - 1).name, list.get(5), NISSAN);        
    }
    
    @Test
    public void sortAutomobileByMilesPerGallonAsc() {
        List<Automobile> list = Automobile.Sorter.sort(autoArrays, "milesPerGallon", true);
        
        //verify the first, last, and size
        Assert.assertEquals("arrays is not the correct size", list.size(), len);
        Assert.assertEquals("The first element name should be: Jeep, is " + list.get(0).name, list.get(0), JEEP);
        Assert.assertEquals("The last element name should be: Honda, is " + list.get(len - 1).name, list.get(5), HONDA);        
    }
    
    @Test
    public void sortAutomobileByMilesPerGallonDesc() {
        List<Automobile> list = Automobile.Sorter.sort(autoArrays, "milesPerGallon", false);
        
        //verify the first, last, and size
        Assert.assertEquals("arrays is not the correct size", list.size(), len);
        Assert.assertEquals("The first element name should be: Honda, is " + list.get(0).name, list.get(0), HONDA);
        Assert.assertEquals("The last element name should be: Jeep, is " + list.get(len - 1).name, list.get(5), JEEP);        
    }
}