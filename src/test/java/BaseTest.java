import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static Playwright pw;

    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    void launchBrowser() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000));
    }

    @BeforeEach
    void createContextandPage() {
        context = browser.newContext();
        page = context.newPage();
    }
}