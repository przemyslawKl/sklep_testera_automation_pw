package tests;

import com.microsoft.playwright.*;
import org.example.factory.BrowserFactory;
import org.example.utils.Properties;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.utils.StringUtils.removeRoundBrackets;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    private Browser browser;
    private BrowserFactory browserFactory;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    void launchBrowser() {
        browserFactory = new BrowserFactory();
        browser = browserFactory.getBrowser();
    }


    @BeforeEach
    void createContextandPage() {
        context = browser.newContext();

        if(isTracingEnabled()){
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        }
        page = context.newPage();
        page.setViewportSize(Integer.parseInt(Properties.getProperty("browser.width")),
                Integer.parseInt(Properties.getProperty("browser.height")));;
    }

    @AfterEach
    void closeContext(TestInfo testInfo) {
        if(isTracingEnabled()) {
            String traceName = "traces/trace_"
                    + removeRoundBrackets(testInfo.getDisplayName())
                    + "_" + LocalDateTime.now().format(DateTimeFormatter
                    .ofPattern(Properties.getProperty("tracing.date.format"))) + ".zip";
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        }
        context.close();
    }

    @AfterAll
     void closeBrowser() {
        browserFactory.getPw().close();
    }

    private boolean isTracingEnabled() {
        return Boolean.parseBoolean(Properties.getProperty("tracing.enabled"));
    }
}