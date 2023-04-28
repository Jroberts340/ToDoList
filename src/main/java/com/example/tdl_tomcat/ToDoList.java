package com.example.tdl_tomcat;
import entity.Todolist;
import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;

public class ToDoList {

    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("default");

    public Scanner scan = new Scanner(System.in);

    public String readInput() {
        return scan.nextLine();
    }

    // Adding Items to the To Do List
    public static void addIntro() {
        System.out.println();
        System.out.println("Enter 0 to Return");
        System.out.print("Please Add Items To List and Press Enter: ");
    }

    public static void deleteIntro() {
        System.out.println();
        System.out.print("Please Input the Item Number You Wish To Be Removed: ");
    }

    public static void addDB(String item) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;
        try{
            et = em.getTransaction();
            et.begin();
            Todolist td = new Todolist();
            td.setTodo(item);
            em.persist(td);

            et.commit();
            System.out.print("->: ");

        } catch(Exception e){
            if (et != null){
                et.rollback();
            }

        } finally {
            em.close();
        }
    }

    public static void deleteOptionList() {
        EntityManager em = emf.createEntityManager();
        String strQuery = "SELECT td FROM Todolist td WHERE td.id IS NOT NULL";

        TypedQuery<Todolist> tq = em.createQuery(strQuery, Todolist.class);
        List<Todolist> view;
        try {
            view = tq.getResultList();
            view.forEach(views->System.out.println("(" + views.getId() + "):  " + views.getTodo()));
        }
        catch (NoResultException ne){
            ne.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    public static void deleteDB(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;
        String strQuery = "DELETE FROM Todolist td WHERE td.id = :id";

        Query query = em.createQuery(strQuery).setParameter("id", id);
        try {
            et = em.getTransaction();
            et.begin();
            query.executeUpdate();
            et.commit();
        }
        catch (Exception e){
            if (et != null)
                et.rollback();
        }
        finally {
            em.close();
        }
    }

    public static List<Todolist>viewDB() {
        EntityManager em = emf.createEntityManager();
        String strQuery = "SELECT td FROM Todolist td WHERE td.id IS NOT NULL";
        TypedQuery<Todolist> tq = em.createQuery(strQuery, Todolist.class);
        List<Todolist> view;
        try {
            view = tq.getResultList();
            if (!view.isEmpty()) {
                System.out.println("------------");
                System.out.println("To Do List");
                System.out.println("------------");
                view.forEach(views -> System.out.println("-> " + views.getTodo()));

                return view;
            } else {
                System.out.println(" ( List Is Empty )");
            }
        } catch (NoResultException ne) {
            ne.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }
}