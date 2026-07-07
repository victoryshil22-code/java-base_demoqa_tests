import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LogoutTests extends TestBase{

    @Test
    public void successfulLogout() {
        open("/login.html");
    }
}
