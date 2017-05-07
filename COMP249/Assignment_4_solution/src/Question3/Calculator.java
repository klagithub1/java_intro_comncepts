/*KLAJDI KARANXHA
 * 6173780
 * COMP249 Section U
 * Assignment 4*/
package Question3;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 A simplified calculator. 
 The only operations were addition and subtraction.
 In this case according to the assignment we have to add multiplication and division.
*/
public class Calculator extends JFrame 
                        implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    public static final int NUMBER_OF_DIGITS = 30;

    private JTextField ioField; 
    private double result = 0.0;
   

    public static void main(String[] args)
    {
        Calculator aCalculator = new Calculator( );
        aCalculator.setVisible(true);
    }

    public Calculator( )
    {
        setTitle("Simplified Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout( ));

        JPanel textPanel = new JPanel( );
        textPanel.setLayout(new FlowLayout( ));
        ioField = 
             new JTextField("0.0", NUMBER_OF_DIGITS);
        ioField.setBackground(Color.WHITE);
        textPanel.add(ioField);
        add(textPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.setLayout(new FlowLayout( )); 

        JButton addButton = new JButton("+"); 
        addButton.addActionListener(this);
        buttonPanel.add(addButton); 
        
        JButton subtractButton = new JButton("-"); 
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton); 
        
        //Adding multiplication button
        JButton multiplyButton = new JButton("*"); 
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton); 
        
        //adding division button
        JButton divisionButton = new JButton("/"); 
        divisionButton.addActionListener(this);
        buttonPanel.add(divisionButton);
        
        //adding "=" button
        JButton equalButton = new JButton("="); 
        equalButton.addActionListener(this);
        buttonPanel.add(equalButton);
       
        JButton resetButton = new JButton("Reset"); 
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

       add(buttonPanel, BorderLayout.CENTER);
    }


    public void actionPerformed(ActionEvent e)
    {
        try
        {
            assumingCorrectNumberFormats(e);
        }
        catch (NumberFormatException e2)
        {
            ioField.setText("Error: Reenter Number.");
        }
    }


    //Throws NumberFormatException.
    public void assumingCorrectNumberFormats(ActionEvent e)
    {
        String actionCommand = e.getActionCommand( );
        
        double intermed;
        
        if (actionCommand.equals("+"))
        {	
        	
            result = result + stringToDouble(ioField.getText( ));
            
            ioField.setText(Double.toString(result));
        }
        else if (actionCommand.equals("-"))
        {
            result = result - stringToDouble(ioField.getText( ));
            ioField.setText(Double.toString(result));

        }
        else if (actionCommand.equals("Reset"))
        {
            result = 0.0;
            ioField.setText("0.0");
        }
        else if (actionCommand.equals("*"))
        {
        	result = result * stringToDouble(ioField.getText( ));
            ioField.setText(Double.toString(result));
        }
        else if (actionCommand.equals("/"))
        {
        	result = result / stringToDouble(ioField.getText( ));
            ioField.setText(Double.toString(result));
        }
        else if (actionCommand.equals("="))
        {
        	
            ioField.setText(Double.toString(result));
        }
        else
            ioField.setText("Unexpected error.");
     }


    //Throws NumberFormatException.
    private static double stringToDouble(String stringObject)
    {
        return Double.parseDouble(stringObject.trim( ));
    }

}
