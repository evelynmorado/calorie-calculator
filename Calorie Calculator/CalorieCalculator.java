import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalorieCalculator extends JFrame {

    CalorieCalculator() {

        JFrame frame = new JFrame("Calorie Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(970, 970);

        //personal logo
        ImageIcon image = new ImageIcon("logo.jpg");
        frame.setIconImage(image.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.setBackground(Color.black);

        //prompt user for their weight 
        JLabel weightPrompt = new JLabel("Enter your weight in kg:");
        weightPrompt.setFont(new Font("arial", Font.PLAIN, 18));
        weightPrompt.setForeground(Color.white);
        weightPrompt.setBackground(Color.black);
        weightPrompt.setOpaque(true);
        JTextField weightInput = new JTextField();
        weightInput.setFont(new Font("arial", Font.PLAIN, 18));
        weightInput.setForeground(Color.white);
        weightInput.setBackground(Color.black);
        weightInput.setOpaque(true);

        //prompt user for their height
        JLabel heightPrompt = new JLabel("Enter your height in cm: ");
        heightPrompt.setFont(new Font("arial", Font.PLAIN, 18));
        heightPrompt.setForeground(Color.white);
        heightPrompt.setBackground(Color.black);
        heightPrompt.setOpaque(true);
        JTextField heightInput = new JTextField();
        heightInput.setFont(new Font("arial", Font.PLAIN, 18));
        heightInput.setForeground(Color.white);
        heightInput.setBackground(Color.black);
        heightInput.setOpaque(true);

        //prompt user for their age
        JLabel agePrompt = new JLabel("Enter your age:");
        agePrompt.setFont(new Font("arial", Font.PLAIN, 18));
        agePrompt.setForeground(Color.white);
        agePrompt.setBackground(Color.black);
        agePrompt.setOpaque(true);
        JTextField ageInput = new JTextField();
        ageInput.setFont(new Font("arial", Font.PLAIN, 18));
        ageInput.setForeground(Color.white);
        ageInput.setBackground(Color.black);
        ageInput.setOpaque(true);

        //prompt user for their gender
        JLabel genderPrompt = new JLabel("<html>Enter your gender <br>(male or female):</html>");
        genderPrompt.setFont(new Font("arial", Font.PLAIN, 18));
        genderPrompt.setForeground(Color.white);
        genderPrompt.setBackground(Color.black);
        genderPrompt.setOpaque(true);
        JTextField genderInput = new JTextField();
        genderInput.setFont(new Font("arial", Font.PLAIN, 18));
        genderInput.setForeground(Color.white);
        genderInput.setBackground(Color.black);
        genderInput.setOpaque(true);

        //prompt user for their activity level
        JLabel activityPrompt = new JLabel("<html>Enter your activity level (sedentary, lightly active,<br> moderately active, or very active):</html>");
        activityPrompt.setFont(new Font("arial", Font.PLAIN, 18));
        activityPrompt.setForeground(Color.white);
        activityPrompt.setBackground(Color.black);
        activityPrompt.setOpaque(true);
        JTextField activityInput = new JTextField();
        activityInput.setFont(new Font("arial", Font.PLAIN, 18));
        activityInput.setForeground(Color.white);
        activityInput.setBackground(Color.black);
        activityInput.setOpaque(true);

        //calculates user's TDEE
        JButton calculate = new JButton("Calculate TDEE");
        calculate.setFont(new Font("arial", Font.PLAIN, 22));
        calculate.setForeground(Color.red);
        calculate.setBackground(Color.black);
        calculate.setOpaque(true);

        //display activity level options
        JButton activity = new JButton("<html>Activity Levels:<br>sedentary (little to no exercise)<br>lightly active (exercise 1-3 days/week)<br>moderately active (exercise 3-5 days/week)<br>very active (exercise 6-7 days a week)</html>");
        activity.setFont(new Font("arial", Font.PLAIN, 18));
        activity.setForeground(Color.red);
        activity.setBackground(Color.black);
        activity.setOpaque(true);

        panel.add(weightPrompt);
        panel.add(weightInput);
        panel.add(heightPrompt);
        panel.add(heightInput);
        panel.add(agePrompt);
        panel.add(ageInput);
        panel.add(genderPrompt);
        panel.add(genderInput);
        panel.add(activityPrompt);
        panel.add(activityInput);
        panel.add(calculate);
        panel.add(activity);
        frame.add(panel);
        
        calculate.addActionListener(new 
        ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightInput.getText());
                double height = Double.parseDouble(heightInput.getText());
                double age = Double.parseDouble(ageInput.getText());
                String gender = genderInput.getText();
                String activityLevel = activityInput.getText();

                double TDEE = 0.0;

                //use Harris-Benedict formula to calculate TDEE
                if (gender.equalsIgnoreCase("male")) {
                    TDEE = 66.5 + (13.75 * weight) + (5.003 * height) - (6.75 * age);
                } else if (gender.equalsIgnoreCase("female")) {
                    TDEE = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
                } 

                if(activityLevel.equalsIgnoreCase("sedentary")) {
                    TDEE = TDEE * 1.2;
                } else if (activityLevel.equalsIgnoreCase("lightly active")) {
                    TDEE = TDEE * 1.375;
                } else if (activityLevel.equalsIgnoreCase("moderately active")) {
                    TDEE = TDEE * 1.55;
                } else if (activityLevel.equalsIgnoreCase("very active")) {
                    TDEE = TDEE * 1.725;
                }

                //format TDEE to 2 decimal places
                TDEE = Math.round(TDEE * 100);
                TDEE = TDEE / 100;

                //displays user's TDEE 
                JOptionPane.showMessageDialog(frame, "Your TDEE is: " + TDEE + " calories per day.");
            }
        });
        frame.setVisible(true);
    }
    
    }
