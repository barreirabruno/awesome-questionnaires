package br.com.awesomequestionnaires.CLI;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class MainMenuTest {

    @Test void ensureItCallsWelcomeMessageMethodSuccessfully() {
        String expected = "========================================\n" + "Greetings and welcome from Awesome Questionnaires.\n" + "========================================\n";
        MainMenu classUndertest = new MainMenu();
        assertNotNull(classUndertest.welcomeMessage(), expected);
    }

    @Test void ensureItBootsMainMenuSuccessfully() {
        MainMenu menu = spy(new MainMenu());

        menu.boot();

        verify(menu, times(1)).welcomeMessage();
    }
}
