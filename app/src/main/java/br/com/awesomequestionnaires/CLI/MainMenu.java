package br.com.awesomequestionnaires.CLI;


public class MainMenu {

    public String welcomeMessage() {
        return "========================================\n" + "Greetings and welcome from Awesome Questionnaires.\n" + "========================================\n";
    }

    public String generalMenuOptions() {
        return  "Type 0 to create a new questionnaire\n" + //
                        "Type 1 for manage questionnaires\n" + //
                        "Type 2 to respond questionnaires\n" + //
                        "Type 3 for exit\n" + //
                        "\n" + //
                        "Please, type your option ";
    }

    public void boot() {
        this.welcomeMessage();
    }


}
