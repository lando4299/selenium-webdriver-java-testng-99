package testng;
import org.testng.Assert;

public class Topic_01_Assertion {
    public  static  void  main(String[] args ){
        // 3 ham chinh de kiem tra tính đúng đắn của dữ liệu
        boolean gender = 3 < 5;

        // Kiểm tra dữ liệu nó phải đúng
        Assert.assertTrue(gender);

        //Kiểm tra dữ liệu nó phải sai

        Assert.assertFalse(3 > 5);

        // Kiểm tra dữ liệu nó phải bằng vời mong đợi
        // Kiểu dữ liệu giống nhau
        // Giá trị dữ liệu phải bằng nhau
         Assert.assertEquals(4, 5);
         Assert.assertEquals("Lan","test");
    }
}
