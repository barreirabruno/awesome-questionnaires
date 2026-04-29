package br.com.awesomequestionnaires.CLI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Stream;

import br.com.awesomequestionnaires.domain.ActiveStatus;
import br.com.awesomequestionnaires.domain.Questionnaire;

import com.fasterxml.jackson.databind.ObjectMapper;

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

    public String questionnaireNameMessage() {
        return "1 - Questionnaire name";
    }

    public String questionnaireDescriptionMessage() {
        return "2 - Questionnaire description";
    }

    public String questionnaireActiveMessage() {
        return "4 - Publish now? Yes/No";
    }

    public String getGeneralMenuUserOption() {
        return this.scan.next();
    }

    public Path createQuestionnaireFile() throws IOException {
        Path root = Path.of("").toAbsolutePath();
        Path questionnairesDirectory = root.resolve("questionnaires");

        Files.createDirectories(questionnairesDirectory);

        String fileName = "questionnaire_" + UUID.randomUUID() + ".json";
        Path questionnaireFile = questionnairesDirectory.resolve(fileName);
        
        Files.createFile(questionnaireFile);
        Files.writeString(questionnaireFile, "{}");

        return questionnaireFile;
    }

    public void recordQuestionnaire(Path filePath, String questionnaire) throws IOException {
        Files.writeString(filePath, questionnaire);
    }

    public Path resolveQuestionnairesFolderPath() {
        String rootPath = "";
        String folderName = "questionnaires";
        return Path.of(rootPath).resolve(folderName);
    }

    public String getQuestionnaireShortName(String path) {
        String fileName = path.substring(path.lastIndexOf('/') + 1);
        String uuidPart = fileName
            .replace("questionnaire_", "")
            .replace(".json", "");

        String[] uuidBlocks = uuidPart.split("-");
        return uuidBlocks[uuidBlocks.length - 1];
    }

    public String openFile(Path filePath) throws IOException {
        return Files.readString(filePath);
    }

    public boolean isQuestionnaireActive(Path filePath) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Questionnaire questionnaire = mapper.readValue(
                filePath.toFile(),
                Questionnaire.class
            );

            return questionnaire.getStatus() == ActiveStatus.TRUE;
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo do questionário: " + e.getMessage());
            return false;
        }
    }

    public void questionnairesActions(String userOption) throws IOException {
        switch (userOption) {
            case "0":
                System.out.println("Creating a new questionnaire file...");
                Path questionnaireFile = this.createQuestionnaireFile();
                System.out.println(questionnaireFile);
                Questionnaire questionnaire = new Questionnaire();
                
                System.out.println(this.questionnaireNameMessage());
                String questionnaireTitle = this.scan.nextLine();
                questionnaire.setTitle(questionnaireTitle);

                System.out.println(this.questionnaireDescriptionMessage());
                String questionnaireDescription = this.scan.nextLine();
                questionnaire.setDescription(questionnaireDescription);

                System.out.println(this.questionnaireActiveMessage());
                String questionnaireActiveOption = this.scan.nextLine();
                if(questionnaireActiveOption.equals("Yes")) {
                    questionnaire.setStatus(ActiveStatus.TRUE);
                } else {
                    questionnaire.setStatus(ActiveStatus.FALSE);
                }
                this.recordQuestionnaire(questionnaireFile, questionnaire.toJson());
                System.out.println("Questionnaire create successfully");
                break;
            case "1":
                HashMap<String, String> questionnaireNamesAndFiles = new HashMap<>();               
                System.out.println("You can manage the following questionnaires: ");
                Path questionnairesFolder = this.resolveQuestionnairesFolderPath();
                Stream<Path> stream = Files.list(questionnairesFolder);
                stream.forEach(file -> {
                    String qNameString = file.toString();
                    String qName = getQuestionnaireShortName(qNameString);
                    if(this.isQuestionnaireActive(file)) {
                        questionnaireNamesAndFiles.put(qName, qNameString);
                        System.out.println(" q: " + qName);
                    }
                });
                System.out.println("Type at least three characters of a questionnaire name to manage it: ");
                String findQuestionnaireToEdit = this.scan.nextLine();
                // if(findQuestionnaireToEdit.isEmpty() || findQuestionnaireToEdit.length() < 3) {
                //     System.out.println("[ERROR]: Please, inform at least three characters to find a questionnnaire, try again: ");
                //     findQuestionnaireToEdit = this.scan.nextLine();
                // }
                for(String questionnaireName: questionnaireNamesAndFiles.keySet()) {
                    if(questionnaireName.contains(findQuestionnaireToEdit)) {
                        Path path = Path.of(questionnaireNamesAndFiles.get(questionnaireName));
                        System.out.println(this.openFile(path));
                    }
                }
                break;
            case "2":
                
                break;
            case "3":
                
                break;
            default:
                System.out.println("Invalid option");
                this.boot();
                break;
        }
    }

    public void boot() throws IOException {
        System.out.println(this.welcomeMessage());
        System.out.println(this.generalMenuOptions());
        String generalMenuUserOption = this.scan.nextLine();
        this.questionnairesActions(generalMenuUserOption);
    }
}
