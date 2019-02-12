// Java assignment 1 by 1604361
// takes integer values from 3 different text boxes and changes the colour of a text in the middle of the gui.
// enjoyable and easy assignment


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class CE203_2018_Ex1 {

    public static void main( String[] args )
    {
        FilledFrame frame = new FilledFrame();

        frame.setVisible( true );
    }

}
class FilledFrame extends JFrame{


    static int size = 300;
    JLabel regLab;
    JTextField txtLeft;
    JTextField txtMid;
    JTextField txtRight;

    public FilledFrame()
    {
        setSize( size+100, size+50 );

        JButton butReset   = new JButton("Reset"); //code for the reset button
        JPanel resPanel = new JPanel();
        resPanel.add(butReset);
        add(resPanel, BorderLayout.NORTH);
        butReset.addActionListener(new resetColButton(this));


        regLab = new JLabel("CE203 Assignment 1, submitted by: 1604361"); //code for the label that will change color
        regLab.setForeground(Color.BLUE);
        JPanel regPanel = new JPanel();
        regPanel.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.ipady = 40;
        grid.weightx = 0.0;
        grid.gridwidth = 3;
        grid.gridx = 0;
        grid.gridy = 1;
        regPanel.add(regLab,  grid);
        add(regPanel);

        txtLeft = new JTextField("0",5); //code for the text fields and button which will change col
        txtMid = new JTextField("0",5);
        txtRight = new JTextField("0",5);
        JButton butChangeCol   = new JButton("Change col");
        butChangeCol.addActionListener(new changeColButton(this));
        JPanel botPanel = new JPanel();
        botPanel.add(txtLeft);
        botPanel.add(txtMid);
        botPanel.add(txtRight);
        botPanel.add(butChangeCol);
        add(botPanel,BorderLayout.SOUTH);

    }
}

class resetColButton implements ActionListener {
    FilledFrame theApp;

    resetColButton(FilledFrame app) {
        theApp = app;

    }

    public void actionPerformed(ActionEvent e) {
        theApp.regLab.setForeground(new Color(0,0,255));
        theApp.txtLeft.setText("");
        theApp.txtMid.setText("");
        theApp.txtRight.setText("");


    } //resets colour to black

}
class changeColButton implements ActionListener {
    FilledFrame theApp;

    changeColButton(FilledFrame app) {
        theApp = app;

    }

    public void actionPerformed(ActionEvent e) {
        String stringArrCol [] = new String[3];
        int intArrCol [] = new int[3];
        stringArrCol[0] = theApp.txtLeft.getText();
        stringArrCol[1] = theApp.txtMid.getText();
        stringArrCol[2] = theApp.txtRight.getText();//places the inputs from text fields into array

        for(int i = 0; i < stringArrCol.length; i++){
            try {
                int result = Integer.parseInt(stringArrCol[i]); //to to change the string into a int
                if( result > 256){JOptionPane.showMessageDialog(null, "Value must be lower then 255 ", "Erm... HELLO?", JOptionPane.WARNING_MESSAGE);
                if(i == 0){ theApp.txtLeft.setText("255");}
                else if (i == 1){ theApp.txtMid.setText("255");}
                else if( i == 2){theApp.txtRight.setText("255");}}//if value is larger then 255 then set it to 255
                else {intArrCol[i] = result; }

                if(0 >= result ){JOptionPane.showMessageDialog(null, "Value must be a positive integer", "Erm... HELLO?", JOptionPane.WARNING_MESSAGE);
                    if(i == 0){ theApp.txtLeft.setText("200");}
                    else if (i == 1){ theApp.txtMid.setText("200");}
                    else if( i == 2){theApp.txtRight.setText("200");}} // if value is negative set it to 200
                else {intArrCol[i] = result; }
            }

        catch (NumberFormatException c) {
            JOptionPane.showMessageDialog(null, "Value must be a number" , "Erm... HELLO?", JOptionPane.WARNING_MESSAGE);
            if(i == 0){ theApp.txtLeft.setText("0");}
            else if (i == 1){ theApp.txtMid.setText("0");}
            else if( i == 2){theApp.txtRight.setText("0");}// if value is not a number it is set to 0
        }}
        theApp.regLab.setForeground(new Color(intArrCol[0],intArrCol[1],intArrCol[2]));// changes the colour of the label
    }
}



