package bad;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import print.Excelreport;
public class Base {
public WebDriver driver;
Excelreport obj= new Excelreport("E:\\chromedriver_win32\\Book2.xlsx");
@BeforeMethod
public void setup() {
System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://opensource-demo.orangehrmlive.com/");
}
@AfterMethod
public void tearDown() {
driver.quit();
}
@DataProvider(name ="Credentials1")
public Object[][] getExcelData() {
//Totals rows count
int rows=obj.getRowCount("data");
//Total Columns
int column=obj.getColumnCount("data");
int actRows=rows-1;
Object[][] data= new Object[actRows][column];
for(int i=0;i<actRows;i++) {
for(int j=0; j<column;j++) {
data[i][j]=obj.getCellData("data", j, i+2);
}
}
return data;
}
}

