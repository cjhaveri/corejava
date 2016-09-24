package test.cjhaveri.corejava.concurrency.tricks;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by chetanjhaveri on 9/24/16.
 */
public class LengthOfLongestSubstringTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"egg", 2},
                {"chetan", 6},
                {"abcabcdef", 6},
                {"pwwkew", 3},
                {"bbbbb", 1},
                {"abcabcbb", 3},
                {null,0}
        };
    }

    @Test(dataProvider = "testData")
    public void testLengthOfLongestSubstring(String s, int expectedLength) throws Exception {

        LengthOfLongestSubstring driver = new LengthOfLongestSubstring();
        Assert.assertEquals(driver.lengthOfLongestSubstring(s), expectedLength);
    }

}