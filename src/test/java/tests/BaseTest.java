package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.utils.StringUtils.removeRoundBrackets;

public class BaseTest {

    protected static Playwright pw;

    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000));
    }

    @BeforeEach
    void createContextandPage() {
        context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true)
        );
        page = context.newPage();
        page.setViewportSize(1920, 1080);
    }

    @AfterEach
    void closeContext(TestInfo testInfo) {
        String traceName = "traces/trace_"
                + removeRoundBrackets(testInfo.getDisplayName())
                + "_" + LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".zip";
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        pw.close();
    }
}