package DairyApp;

import javax.swing.*;
import java.util.Scanner;

public class DiaryMain {
    private static Diary diary;

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        createDiary();
        goToMainMenu();
    }

    private static void createDiary(){
            display("Enter your username: ");
            String username = scanner.nextLine();
            display("Enter your password: ");
            String password = scanner.nextLine();
            diary = new Diary(username, password);
            display("Diary created successfully! ");
            display("Welcome " + username);
            diary.unlockDiary(password);
            goToMainMenu();
    }
    private static void goToMainMenu(){
        String mainMenu = """
                ============================
                        MY JOURNAL
                ============================
                  WELCOME TO YOUR JOURNAL
                =============================
                1 ==> Add Entry
                2 ==> View Entry
                3 ==> EXIT Diary
                4 ==> Edit Entry
                5 ==> Delete Entry
                ============================
                """;
//        7 ==> View all entries

        display(mainMenu);
      int selected = scanner.nextInt();
      scanner.nextLine();
        if(selected < 0 && selected > 6 ) System.out.printf("%s%n" , "Invalid input. Enter a valid number" , mainMenu);
        switch (selected){
            case 1 -> addEntry();
            case 2 -> findEntry();
            case 3 -> lockDiary();
            case 4 -> editEntry();
            case 5 -> deleteEntry();
            default -> goToMainMenu();
        }
    }


    private static void addEntry() {
        display("TITLE: ");
        String title = scanner.nextLine();
        display("BODY: Dear Diary... ");
        String body = scanner.nextLine();
        diary.createEntry(title, body);
        display("Entry created successfully ");
        goToMainMenu();
    }

    private static void editEntry() {
        display("Enter password");
        String password = scanner.nextLine();
        diary.unlockDiary(password);
        display("Enter entry id to be edited: ");
        int entryToBeEdited = scanner.nextInt();
        display("TITLE:");
        scanner.nextLine();
        String title = scanner.nextLine();
        display("BODY: Dear Diary... ");
        String body = scanner.nextLine();
        diary.updateEntry(entryToBeEdited,title,body);
        display("Entry edited and saved successfully! ");
        goToMainMenu();

    }


    private static void findEntry(){
        display("Enter entry ID to search for ");
        int id = scanner.nextInt();
        System.out.println(diary.findEntryById(id));
        goToMainMenu();
    }

    private static void lockDiary() {
       display("Thanks for using our application.Goodbye...");
       System.exit(0);
    }

    private static void unlockDiary() {
        display("Diary Unlocked!");
    }
    private static void deleteEntry() {
        display("Enter password");
        String password = scanner.nextLine();
        diary.unlockDiary(password);
        display("Enter entry id to be deleted: ");
        int entryToBeDeleted = scanner.nextInt();
        diary.deleteEntry(entryToBeDeleted);
        display("Entry deleted!");
        goToMainMenu();
    }

    private static void display(String prompt){
//        JOptionPane.showMessageDialog(null, prompt);
        System.out.println(prompt);
    }
}
