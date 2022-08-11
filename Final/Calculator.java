import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator extends JFrame {

private double Num1 = 0;
private double Num2 = 0;
private byte function = -1;


private JTextField resultJText;

public Calculator() {

    JButton[] numberButtons = new JButton[10];

    for ( int i = 9; i >= 0; i--) {
        numberButtons[i] = new JButton(Integer.toString(i));
        numberButtons[i].setBackground(Color.BLACK);
        numberButtons[i].setForeground(Color.RED);
    }

    JButton enterButton     = new JButton("Enter");
    enterButton.setBackground(Color.BLACK);
    enterButton.setForeground(Color.RED);
    JButton cButton         = new JButton("C");
    cButton.setBackground(Color.BLACK);
    cButton.setForeground(Color.RED);
    JButton multiplyButton  = new JButton("*");
    multiplyButton.setBackground(Color.BLACK);
    multiplyButton.setForeground(Color.RED);
    JButton divideButton    = new JButton("/");
    divideButton.setBackground(Color.BLACK);
    divideButton.setForeground(Color.RED);
    JButton addButton       = new JButton("+");
    addButton.setBackground(Color.BLACK);
    addButton.setForeground(Color.RED);
    JButton substractButton = new JButton("-");
    substractButton.setBackground(Color.BLACK);
    substractButton.setForeground(Color.RED);
    resultJText = new JTextField();
      resultJText.setPreferredSize(new Dimension(160, 40));
      resultJText.setBackground(Color.GRAY);
        resultJText.setEnabled(false);
        resultJText.setHorizontalAlignment(4);
        resultJText.setDisabledTextColor(Color.BLACK);


    JPanel motherPanel = new JPanel();
        motherPanel.setLayout(new BoxLayout(motherPanel, BoxLayout.Y_AXIS));
    
    JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(160, 20));
        textPanel.add(resultJText);

    JPanel numberButtonsPanel = new JPanel();
        numberButtonsPanel.setPreferredSize(new Dimension(160, 100));
   numberButtonsPanel.setBackground(Color.BLACK);
        for(int i = 9; i>=0; i--) {
            numberButtonsPanel.add(numberButtons[i]);
            
        }

    JPanel functionButtonPanel = new JPanel();
        functionButtonPanel.setPreferredSize(new Dimension(160, 35));
        functionButtonPanel.add(enterButton);
        functionButtonPanel.add(cButton);
        functionButtonPanel.add(multiplyButton);
        functionButtonPanel.add(divideButton);
        functionButtonPanel.add(addButton);
        functionButtonPanel.add(substractButton);
      functionButtonPanel.setBackground(Color.BLACK);

    numberButtonsAction[] numberButtonActions = new numberButtonsAction[10];
    for ( int i = 0; i < 10; i++ ) {
        numberButtonActions[i] = new numberButtonsAction(numberButtons[i]);
        numberButtons[i].addActionListener(numberButtonActions[i]);
        numberButtons[i].setForeground(Color.RED);
    }
    EnterButton enter = new EnterButton();
        enterButton.addActionListener(enter);

    CButton c = new CButton();
        cButton.addActionListener(c);

    MultiplyButton multiply = new MultiplyButton();
        multiplyButton.addActionListener(multiply);

    DivideButton divide = new DivideButton();
        divideButton.addActionListener(divide);

    AddButton add = new AddButton();
        addButton.addActionListener(add);

    SubtractButton subtract = new SubtractButton();
        substractButton.addActionListener(subtract);

    motherPanel.add(textPanel);
    motherPanel.add(numberButtonsPanel);
    motherPanel.add(functionButtonPanel);
    add(motherPanel);

    setTitle("ButtonTest");
    setSize(180, 290);
    setLocationByPlatform(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);

}

private class numberButtonsAction implements ActionListener {

    private String c;

    public numberButtonsAction(JButton a) {
        this.c = a.getText();
        
         }

    public void actionPerformed(ActionEvent e) {
        if (!resultJText.getText().equals("0.0")) {
            resultJText.setText(resultJText.getText() + c);
        } else {
            resultJText.setText("");
            actionPerformed(e);
        }
    }
}

private class EnterButton implements ActionListener 
{

    
    public void actionPerformed(ActionEvent e) 
    {
        Num2 = Double.parseDouble(resultJText.getText());

        if (function == 0) {
            resultJText.setText(Double.toString((Math.round((Num1 / Num2) * 100)) / 100));
        } else if (function == 1) {
            resultJText.setText(Double.toString(Num1 * Num2));
        } else if (function == 2) {
            resultJText.setText(Double.toString(Num2 + Num1));
        } else if (function == 3) {
            resultJText.setText(Double.toString(Num1 - Num2));
        } else {
            resultJText.setText(String.valueOf(Num1));
        }
            Num1 = Double.parseDouble(resultJText.getText());
    }


}

private class CButton implements ActionListener {

    
    public void actionPerformed(ActionEvent e) {
        resultJText.setText("");
        Num1 = 0;
        Num2 = 0;

        function = -1;
    }


}

private class DivideButton implements ActionListener {

   
    public void actionPerformed(ActionEvent e) {
        if (Num1 == 0) {
            Num1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            Num2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 0;
    }

}

private class MultiplyButton implements ActionListener 
{

    
    public void actionPerformed(ActionEvent e) {
        if (Num1 == 0) {
            Num1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            Num2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 1;
    }


}


    private class AddButton implements ActionListener 
   {

    
    public void actionPerformed(ActionEvent e) 
    {
        if (Num1 == 0) {
            Num1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            Num2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 2;
    }

}

private class SubtractButton implements ActionListener {

    
    public void actionPerformed(ActionEvent e) {
        if (Num1 == 0) {
            Num1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            Num2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 3;
    }
   }
   
    public static void main(String[]args)
    {
    new Calculator();
}
}

