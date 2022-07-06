package TestNGListeners;


import ZaleniumClass.ZaleniumTestNGTest;
import org.openqa.selenium.Cookie;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Success of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Failure of test cases and its details are : "+result.getName());
        Cookie cookie = new Cookie("zaleniumTestPassed", "false");
        ZaleniumTestNGTest.driver.manage().addCookie(cookie);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Skip of test cases and its details are : "+result.getName());
    }

}
