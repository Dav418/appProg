import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class DrawCalc extends JFrame{
    private JPanel panelZero;
    private JPanel panelOne;//holds the shapes
    private JPanel panelTwo;//holds the buttons and text box for input

    Square square;//TO DO same for circles
    Circle circle;

    JTextField txtField;

    public DrawCalc() {
        setSize(800,500); //sets the panels size

        square = new Square(15, 15, 50);// draw initial square and circle
        circle = new Circle(215,15,50);

        panelOne = new JPanel() {
            // We are overriding the paintComponent method of the JPanel
            public void paintComponent(Graphics g) {

                // This should call the draw methods for each Shape, example for square given below:
                square.draw(g);
                circle.draw(g);
            }
        };



        panelTwo = new JPanel();

        txtField = new JTextField(10);

        JButton btnSetSquare = new JButton("Set square size");
        JButton btnCalcSquareArea = new JButton("Calculate square area");

        JButton btnSetCircle = new JButton("Set circle size");
        JButton btnCalcCircleArea = new JButton("Calculate circle area");

        panelTwo.add(txtField);
        panelTwo.add(btnSetSquare);
        panelTwo.add(btnCalcSquareArea);

        panelTwo.add(btnSetCircle);
        panelTwo.add(btnCalcCircleArea);

        btnSetSquare.addActionListener(new ButtonHandler(this, 1));
        btnCalcSquareArea.addActionListener(new ButtonHandler(this, 2));
        btnSetCircle.addActionListener(new ButtonHandler(this, 3));
        btnCalcCircleArea.addActionListener(new ButtonHandler(this, 4));

        add(panelOne, BorderLayout.CENTER);
        add(panelTwo,BorderLayout.SOUTH);
    }
    // entry point to the program
    public static void main(String[] args) {
        new DrawCalc().setVisible(true);
    }
}

class ButtonHandler implements ActionListener {
    private DrawCalc theApp;
    private int action;

    public ButtonHandler(DrawCalc theApp, int action) {
        this.theApp = theApp;
        this.action = action;
    }

    public void actionPerformed(ActionEvent e) {


        if(this.action == 1) { //set square side length

            try {

                this.theApp.square.sideLength = Integer.valueOf(theApp.txtField.getText());


                this.theApp.repaint();
            } catch (NumberFormatException ex) {
                System.out.println("Can't cast '" + theApp.txtField.getText() + "' to Integer.");
            }
        }

        if(this.action == 2) { //calculate square area
            try{
                    int y = theApp.square.getArea();
                    theApp.txtField.setText("The area of the square is " + y);


            }catch (NumberFormatException ex) {
                System.out.println("Can't cast '" + theApp.txtField.getText() + "' to Integer.");
            }

        }
        if(this.action ==3){//set circle radius
            try {

                this.theApp.circle.r = Integer.valueOf(theApp.txtField.getText());


            this.theApp.repaint();
        } catch (NumberFormatException ex) {
            System.out.println("Can't cast '" + theApp.txtField.getText() + "' to Integer.");
        }}
        if(this.action ==4){ try { //calculate area of circle

            double y = theApp.circle.getArea();
            DecimalFormat formatter = new DecimalFormat("#0.00");
            theApp.txtField.setText("The area of the circle is " + formatter.format(y));
        } catch (NumberFormatException ex) {
            System.out.println("Can't cast '" + theApp.txtField.getText() + "' to Integer.");
        }}


    }
}