import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class LoginTests extends TestBase {

       @Test
       public void successfulAuthorization() {
              open("/login.html");

              $("[data-testid=login-input]").setValue("user1");
              $("[data-testid=password-input]").setValue("password1");
              $("[data-testid=submit-button]").click();

              $("[data-testid=welcome-message]").shouldHave(text("Welcome, user1!"));
       }

       @Test
//    @Disabled("Login by Press Enter is not implemented yet")
       public void successfulAuthorizationWithPressEnter() {
              open("/login.html");

              $("[data-testid=login-input]").setValue("user1");
              $("[data-testid=password-input]").setValue("password1").pressEnter();

              $("[data-testid=welcome-message]").shouldHave(text("Welcome, user1!"));
       }

       @Test
       public void wrongPasswordAuthorizationTest() {
              open("/login.html");

              $("[data-testid=login-input]").setValue("user1");
              $("[data-testid=password-input]").setValue("password13");
              $("[data-testid=submit-button]").click();

              $("[data-testid=error-message]").shouldHave(text("Wrong login or password"));
       }

       @Test
       public void wrongLoginAuthorizationTest() {
              open("/login.html");

              $("[data-testid=login-input]").setValue("user2");
              $("[data-testid=password-input]").setValue("password1");
              $("[data-testid=submit-button]").click();

              $("[data-testid=error-message]").shouldHave(text("Wrong login or password"));
       }

       @Test
       public void emptyLoginAuthorizationTest() {
              open("/login.html");

              $("[data-testid=password-input]").setValue("password1");
              $("[data-testid=submit-button]").click();

              $("[data-testid=error-message]")
                      .shouldHave(text("Login is required (minimum 3 characters)"));
       }

       @Test
       public void emptyPasswordAuthorizationTest() {
              open("/login.html");

              $("[data-testid=login-input]").setValue("user1");
              $("[data-testid=submit-button]").click();

              $("[data-testid=error-message]")
                      .shouldHave(text("Password is required (minimum 6 characters)"));
       }

       @Test
       public void authorizationWithLeadingAndTrailingSpacesInCredentialsTest() {
              open("/login.html");

              $("[data-testid=login-input]").setValue(" user1 ");
              $("[data-testid=password-input]").setValue(" password1 ");
              $("[data-testid=submit-button]").click();

              $("[data-testid=welcome-message]").shouldHave(text("Welcome, user1!")); //нет валидации на пробелы
       }

       @Test
       public void shortLoginPasswordAuthorizationTest() {
              open("/login.html");

              $("[data-testid=login-input]").setValue("1");
              $("[data-testid=password-input]").setValue("1");
              $("[data-testid=submit-button]").click();

              $("[data-testid=error-message]")
                      .shouldHave(text("Login must be at least 3 characters"));
       }
}