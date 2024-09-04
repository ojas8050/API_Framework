package api_test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoughClass {
    @DataProvider(name = "userData")
        public Object[][] createUserData() {
            return new Object[][]{
                    {"1010", "testuser1", "John", "Canedy", "a@gmail.com", "test@1", "1234567897"},
                    {"1020", "testuser2", "Kim", "Kom", "b@gmail.com", "test@2", "1234567897"},
                    {"1030", "testuser3", "Smith", "Steve", "c@gmail.com", "test@3", "1234567897"}
            };
        }

        @Test(dataProvider = "userData")
        public void testUser(String userId, String userName, String firstName, String lastName, String email, String password, String phone) {
            System.out.println("UserID: " + userId);
            System.out.println("UserName: " + userName);
            System.out.println("FirstName: " + firstName);
            System.out.println("LastName: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Phone: " + phone);
            // Your test logic here
        }
    }

