import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.io.File; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import tests.*;

public class E2ETestRunner {

    private WebDriver driver;
    private List<String> testResults = new ArrayList<>(); // 테스트 결과 arr
    private int totalTests = 0;  // 전체 테스트 수를 추적하는 변수
    private int failedTests = 0; // 실패한 테스트 수를 추적하는 변수

    public E2ETestRunner() {
        final String WEB_DRIVER_ID = "webdriver.chrome.driver";
        final String WEB_DRIVER_PATH = "C:\\webdriver\\chromedriver-win64\\chromedriver.exe"; // 프로젝트 안에 lib 추가하는게 좋을 듯.
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    
    private String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
    
    public void runTest(String relativePath, HtmlTest test) {
        String basePath = System.getProperty("user.dir");
        String absolutePath = "file:///" + basePath + "/src/main/java/" + relativePath;
        driver.get(absolutePath);
        boolean result = test.execute(driver);
        
        // 파일 이름만 추출합니다.
        File file = new File(relativePath);
        String fileName = file.getName();
        
        testResults.add(fileName + ": " + (result ? "Success" : "Fail"));
        
        totalTests++; // 테스트를 실행할 때마다 전체 테스트 수 증가

        if (!result) {
            failedTests++; // 테스트가 실패하면 실패한 테스트 수 증가
        }
    }

    public void close() {
        driver.quit();
    }
    

    public void runAllTests() {
        File htmlDir = new File("src/main/java/html_samples");
        File[] htmlFiles = htmlDir.listFiles((dir, name) -> name.endsWith(".html"));

        for (File htmlFile : htmlFiles) {
            String baseName = htmlFile.getName().replace(".html", "");
            try {
                Class<?> testClass = Class.forName("tests.Test" + baseName);
                HtmlTest testInstance = (HtmlTest) testClass.getDeclaredConstructor().newInstance();
                runTest("html_samples/" + htmlFile.getName(), testInstance);
            } catch (Exception e) {
                System.out.println("Error running test for " + htmlFile.getName() + ": " + e.getMessage());
            }
        }
    }

    public void printAndSaveResults(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // 테스트 날짜와 시간을 파일 상단에 추가
            writer.write("Test Date and Time: " + getCurrentDateTime());
            writer.newLine();
            writer.newLine();

            // 테스트 결과를 콘솔과 파일에 출력
            for (String result : testResults) {
                System.out.println(result);
                writer.write(result);
                writer.newLine();
            }

            // 전체 테스트 수와 실패한 테스트 수를 콘솔과 파일에 출력
            String summary = "\nTotal Tests: " + totalTests + "\nFailed Tests: " + failedTests;
            System.out.println(summary);
            writer.write(summary);
        }
    }
    
    public static void main(String[] args) {
        E2ETestRunner tester = new E2ETestRunner();

        tester.runAllTests();  // 모든 테스트 실행

        try {
            tester.printAndSaveResults("test_results.txt");  // 결과를 콘솔과 파일에 출력
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        tester.close();
    }
    
    
    // 테스트를 서버에 올려 누구나 할 수 있게. DB. 
}
