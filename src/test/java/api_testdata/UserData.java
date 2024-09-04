package api_testdata;

import org.testng.annotations.DataProvider;

public class UserData {
    @DataProvider(name = "userData")
    public static Object[][] getUserData() {
        return new Object[][]{
                {"1010", "testuser1", "John", "Canedy", "a@gmail.com", "test@1", "1234567897"},
                {"1020", "testuser2", "Kim", "Kom", "b@gmail.com", "test@2", "1234567897"},
                {"1030", "testuser3", "Smith", "Steve", "c@gmail.com", "test@3", "1234567897"}
        };
    }
}
