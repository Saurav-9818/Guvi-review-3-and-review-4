import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class User {
    String name;
    String email;
    double weight;  // Current weight
    ArrayList<Workout> workouts = new ArrayList<>();
    double goalWeight;

    public User(String name, String email, double weight) {
        this.name = name;
        this.email = email;
        this.weight = weight;
        this.goalWeight = weight;
    }

    // Add a workout to the user's log
    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    // Set a goal weight
    public void setGoalWeight(double goal) {
        this.goalWeight = goal;
    }

    // Show the user's progress
    public void showProgress() {
        System.out.println("Current Weight: " + weight + " kg");
        System.out.println("Goal Weight: " + goalWeight + " kg");
        System.out.println("Workouts Logged: " + workouts.size());
    }

    // Display workout log
    public void showWorkoutLog() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts logged yet.");
        } else {
            for (Workout workout : workouts) {
                workout.displayWorkout();
            }
        }
    }
}

class Workout {
    String exercise;
    int sets;
    int reps;
    double weight;  // Weight used for the exercise
    String date;

    public Workout(String exercise, int sets, int reps, double weight, String date) {
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    // Display workout details
    public void displayWorkout() {
        System.out.println("Exercise: " + exercise);
        System.out.println("Sets: " + sets + " Reps: " + reps + " Weight: " + weight + " kg");
        System.out.println("Date: " + date);
        System.out.println("------------------------");
    }
}

public class FitnessTrackingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static User user;

    public static void main(String[] args) {
        // Welcome screen
        System.out.println("Welcome to the Fitness Tracking System!");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your current weight (kg): ");
        double weight = scanner.nextDouble();

        // Create user object
        user = new User(name, email, weight);

        // Main menu loop
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            switch (choice) {
                case 1:
                    addWorkout();
                    break;
                case 2:
                    user.showWorkoutLog();
                    break;
                case 3:
                    setGoalWeight();
                    break;
                case 4:
                    user.showProgress();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Display the menu to the user
    public static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Workout");
        System.out.println("2. View Workout Log");
        System.out.println("3. Set Goal Weight");
        System.out.println("4. View Progress");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Add a new workout to the user's log
    public static void addWorkout() {
        System.out.println("\nEnter the exercise name: ");
        String exercise = scanner.nextLine();
        System.out.println("Enter the number of sets: ");
        int sets = scanner.nextInt();
        System.out.println("Enter the number of reps: ");
        int reps = scanner.nextInt();
        System.out.println("Enter the weight used (kg): ");
        double weightUsed = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline
        System.out.println("Enter the date of the workout (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        // Create a new workout and add it to the user's log
        Workout workout = new Workout(exercise, sets, reps, weightUsed, date);
        user.addWorkout(workout);
        System.out.println("Workout added successfully!");
    }

    // Set a goal weight for the user
    public static void setGoalWeight() {
        System.out.println("\nEnter your goal weight (kg): ");
        double goalWeight = scanner.nextDouble();
        user.setGoalWeight(goalWeight);
        System.out.println("Goal weight set to: " + goalWeight + " kg");
    }
}
