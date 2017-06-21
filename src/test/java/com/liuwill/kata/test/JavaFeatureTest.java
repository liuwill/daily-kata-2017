package com.liuwill.kata.test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by videopls on 2017/3/7.
 */
public class JavaFeatureTest {
    @Test
    public void test() throws Throwable {
        String[] strList = new String[]{};
        assertEquals(0, strList.length);

        String[] strList1 = new String[]{"", ""};
        assertEquals(2, strList1.length);

        String[] strList2 = new String[2];
        assertEquals(2, strList2.length);
    }

    @Test
    public void arrayCopy() {
        String sample = "Bob 91 123 243";
        String[] sampleItems = sample.split(" ");

        assertEquals(sampleItems.length, 4);

        String[] targetItems = new String[sampleItems.length - 1];
        System.arraycopy(sampleItems, 1, targetItems, 0, targetItems.length);

        assertEquals(targetItems[0], "91");
        assertEquals(targetItems[targetItems.length - 1], "243");
    }

    @Test
    public void testJson() {
        JsonParser parser = new JsonParser();
        String context = "2017-06-14T09:40:13.587Z\t3\t12\t1\t101.81.89.65\tbugall\tLinux; Android 6.0.1; ONEPLUS A3000 Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043024 Safari/537.36 MicroMessenger/6.5.4.1000 NetType/WIFI Language/zh_CN\t\t56cc24971594364b00f9dc93\t5757de7deeb87c42055a2726\t57481c4304c2b43001640456\t1\t\t\t\t100\t100\t1024x768\tzh-CN\t1.2.3\t573ed407cc23919a9992aa52\t56cae77cd9feddb94ed1e97c\t566638eebb54b35300809730\t581cae45ca46bd2b00ba1298\t123\t{\"resource\":\"liuwill\", \"emmit\":\"user\"}";
        String[] contextData = context.split("\t");
        assertEquals(26, contextData.length);
        String jsonContext = contextData[25];
        if (jsonContext != null && jsonContext.length() > 0) {
            JsonObject root = parser.parse(jsonContext).getAsJsonObject();

            System.out.print(root.get("resource").getAsString());
            assertEquals("liuwill", root.get("resource").getAsString());
        }
    }

    @AfterClass
    public static void outputResult() {
        System.out.println("Java Feature Test.");
    }
}
