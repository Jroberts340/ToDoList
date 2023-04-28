package com.example.tdl_tomcat;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import entity.Todolist;

public class MainClass {

    private static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("default");

    public static void main(String[] args) throws SQLException {

        ToDoList list = new ToDoList();
        ToDoListApp app = new ToDoListApp(list);
        app.start();

        emf.close();
    }
}

class ToDoListApp {
    public boolean isRunning = true;
    public Scanner scan = new Scanner(System.in);
    public ToDoList td;

    public ToDoListApp(ToDoList list) {
        this.td = list;
    }

    public void start() {
        printIntro();
        while (isRunning) {
            printListOfOptions();
            int optionNum = readAction();
            execute(optionNum);
        }
    }

    public void execute(int num) {
        switch (num) {
            case 1:
                td.addIntro();
                while (true) {
                    String input = td.readInput();
                    if(!input.equals("0")){
                        td.addDB(input);
                    }
                    else
                        break;
                }
                break;

            case 2:
                td.deleteOptionList();
                td.deleteIntro();
                String id = td.readInput();

                td.deleteDB(Integer.parseInt(id));
                break;

            case 3:
                td.viewDB();
                break;

            case 4:
                isRunning = false;
                break;
        }
    }

    public void printIntro() {
        System.out.println("To Do List Application");
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("What Would You Like To Do Today?");
    }

    public void printListOfOptions() {
        System.out.println();
        System.out.println("1. Add To List");
        System.out.println("2. Delete From List");
        System.out.println("3. View List");
        System.out.println("4. Exit");
    }

    public int readAction() {
        List<Integer> options = Arrays.asList(1, 2, 3, 4);
        while (true) {
            try {
                System.out.print("(Number Only) Enter Option: ");
                int action = scan.nextInt();
                if (options.contains(action)) {
                    return action;
                } else {
                    System.out.println("Please enter a valid number option from the list");
                }
            } catch (Exception e) {
                System.out.println("Option must be a number");
            }
        }
    }
}