package br.com.awesomequestionnaires.CLI;

import java.util.Scanner;

public class MainMenu {

    private Scanner scan;
    
    public MainMenu(Scanner scan) {
        this.scan = scan;
    }

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

    public String getGeneralMenuUserOption() {
        return this.scan.next();
    }

    public void boot() {
        System.out.println(this.welcomeMessage());
        System.out.println(this.generalMenuOptions());
        this.getGeneralMenuUserOption();
    }
}
