package br.com.awesomequestionnaires.CLI;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class MainMenuTest {
    @Test void ensureItCallsWelcomeMessageMethodSuccessfully() {
        String expected = "========================================\n" + "Greetings and welcome from Awesome Questionnaires.\n" + "========================================\n";
        MainMenu classUndertest = new MainMenu();
        assertNotNull(classUndertest.welcomeMessage(), expected);
    }
}
