package test.cjhaveri.corejava.concurrency.tricks;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by chetanjhaveri on 9/24/16.
 */
public class IsomorphicStringsTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"egg", "add", true},
                {"rishi","mansa", true},
                {"foo", "bar", false},
                {"paper", "title", true},
                {"paper", "foo", false},
                {null, null, false},
                {"paper", null, false},
                {null, "paper", false}
        };
    }


    @Test (dataProvider = "testData")
    public void testIsIsomorphic(String s, String t, boolean expectedResult) {
        IsomorphicStrings driver = new IsomorphicStrings();
        Assert.assertEquals(driver.isIsomorphic(s, t), expectedResult);

    }

}