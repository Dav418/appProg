// Java assignment 2 by 1604361
// in a nutshell, this is like a notepad clone but it has buttons and stores words in a LinkedList
// added extra bit to display the whole list in the console
// overall very enjoyable assignment, can we have more like this pls?


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CE203_2018_Ex2 {

    public static void main( String[] args )
    {
        FilledFrames frame = new FilledFrames();

        frame.setVisible( true );
    }
public static String setText(LinkedList<String> wordList){//updates the large text box

    String temp ="";
    for(String str : wordList){ //iterate
        temp += str + ", ";
    }
    System.out.println(temp);
    if(temp.isEmpty()){temp = "List is currently empty.";}
    return temp;

}
}
class FilledFrames extends JFrame {


    static int size = 750;
    LinkedList<String> wordList = new LinkedList<>();
    JTextField inputText;
    JTextArea largeTextBox;
    public FilledFrames()
    {

        setSize( size+100, size-200 );

        JPanel butPanel = new JPanel();
        butPanel.setLayout(new GridLayout(3,2));
        JButton butAdd  = new JButton("Add a word");// every button has its own actionHandler
        butAdd.addActionListener(new addWord(this));
        JButton butDisp  = new JButton("Display specific");
        butDisp.addActionListener(new dispByLastChar(this));
        JButton butSearch   = new JButton("Search");
        butSearch.addActionListener(new searchSpecific(this));
        JButton butRemOne  = new JButton("Remove last word");
        butRemOne.addActionListener(new removeOne(this));
        JButton butRemAll   = new JButton("Remove all of that word");
        butRemAll.addActionListener(new removeAll(this));
        JButton butClear  = new JButton("Clear");
        butClear.addActionListener(new clearAll (this));
        JButton butShow  = new JButton("Display List");
        butShow.addActionListener(new showList (this));

        JButton butInvis  = new JButton(""); // invis buttons allow me to have the show button be on the bottom by itself
        JButton butInvis2  = new JButton("");
        butInvis.setOpaque(false);
        butInvis.setContentAreaFilled(false);
        butInvis.setBorderPainted(false);

        butInvis2.setOpaque(false);
        butInvis2.setContentAreaFilled(false);
        butInvis2.setBorderPainted(false);

        butPanel.add(butAdd);
        butPanel.add(butDisp);
        butPanel.add(butSearch);
        butPanel.add(butRemOne);
        butPanel.add(butRemAll);
        butPanel.add(butClear);
        butPanel.add(butInvis);
        butPanel.add(butShow);
        butPanel.add(butInvis2);
        add(butPanel, BorderLayout.NORTH); //this makes all the buttons and adds them into a panel at the top

        JPanel displayPanel = new JPanel();
        largeTextBox = new JTextArea(" ",40,40);
        largeTextBox.setPreferredSize( new Dimension( size, size - 375 ) );
        largeTextBox.setEditable(false);
        largeTextBox.setLineWrap(true);
        largeTextBox.setWrapStyleWord(true);
        displayPanel.add( largeTextBox );
        add(displayPanel,BorderLayout.CENTER); //makes the console

        JPanel botPanel = new JPanel();
        inputText = new JTextField( "" );
        inputText.setPreferredSize(new Dimension(size - 550,size - 726));
        JLabel regNumb = new JLabel("Reg number: 1604361");
        JLabel inputHere = new JLabel("Input here: ");
        botPanel.add(inputHere);
        botPanel.add(inputText);
        botPanel.add(regNumb);
        add(botPanel,BorderLayout.SOUTH); // adds the input box onto the bottom of the application
    }
}

class addWord implements ActionListener { // adds a word into the list
    FilledFrames theApp;

    addWord(FilledFrames app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        String input = theApp.inputText.getText();
        String temp = "";
        if (input.isEmpty()){JOptionPane.showMessageDialog(theApp, "Input cannot be empty.");}
        else{temp = input.substring(0,1);}
         if(temp.matches("^[0-9]*$") ){
            if(!temp.isEmpty()){
            JOptionPane.showMessageDialog(theApp, "Invalid input, words cannot start with a number");}
            theApp.inputText.setText("");}
            else {
                theApp.wordList.add(theApp.inputText.getText());
                theApp.largeTextBox.setText("The word "+theApp.inputText.getText()+ " has been added ont the list.");}
    }

}
class dispByLastChar implements ActionListener { // displays by the last character
    FilledFrames theApp;

    dispByLastChar(FilledFrames app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        String input = theApp.inputText.getText();
        if (!input.isEmpty()) { // checks if its a letter
            input = input.toLowerCase();
            input = input.substring(input.length()-1);
            char c = input.charAt(0);
            LinkedList<String> matchingList = new LinkedList<>();
            for(String str : theApp.wordList){ //iterate
                char currentWord= str.charAt(str.length() - 1); //looks at the last character in the word
                if(currentWord==c){matchingList.add(str);} //if it matches, then its put into a list
            }
            String update = CE203_2018_Ex2.setText(matchingList);
            update = update.substring(0, update.length() - 2);
            theApp.largeTextBox.setText("Showing all instances of words ending with: " + c + "\n" + update);
        }else{
            JOptionPane.showMessageDialog(theApp, "Please enter an input."); //shows this error if its a invalid input
            theApp.inputText.setText("");
        }
    }
}
    class searchSpecific implements ActionListener { // searches for the last instance of a supplied word
        FilledFrames theApp;

        searchSpecific(FilledFrames app) {
            theApp = app;
        }

        public void actionPerformed(ActionEvent e) {
            String input = theApp.inputText.getText();

            if (!input.isEmpty()) { // check if input is empty
                int pos =0;
                boolean found = false;
                input=input.toLowerCase();
                ArrayList<Integer> posList = new ArrayList<>();
                for(String str : theApp.wordList){
                    if(input.equals(str)){
                        posList.add(pos);
                        found = true;
                    }
                    pos++;
                }
                if (found){
                    String noOfTimes="";
                    for(int i:posList){noOfTimes = noOfTimes + i + ", ";}
                    noOfTimes = noOfTimes.substring(0, noOfTimes.length() - 2); // used to get rid of the , when displaying the output
                    theApp.largeTextBox.setText("The word "+ input + " has been found "+ posList.size() + " time(s) and is at the following positions in the list: "+noOfTimes );}
                else{theApp.largeTextBox.setText("No instance of "+input+" has been found.");}
            }
            else{
                JOptionPane.showMessageDialog(theApp, "Input cannot be empty.");// if its not a letter show this msg and erase the input text
                theApp.inputText.setText("");
            }

        }

    }
    class removeOne implements ActionListener { //removes the last found instance of a word
        FilledFrames theApp;

        removeOne(FilledFrames app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        String input = theApp.inputText.getText();
        if(input.isEmpty()){JOptionPane.showMessageDialog(theApp,"Input cannot be empty.");}
        else{
        int pos =0;
        int posToBeDeleted = 0;
        boolean found = false;
        for(String str : theApp.wordList){//iterate
            if(input.equals(str)){
                posToBeDeleted=pos;
                found=true;}
                pos++; //if word is found store its position in posToBeDeleted
        }             // this will loop through the whole list, so it will always find the last word


        if(found = false){theApp.largeTextBox.setText("There were no instances of the word '"+input+"' in the list."); theApp.inputText.setText("");}
        else{ theApp.wordList.remove(posToBeDeleted); theApp.largeTextBox.setText("The last instance of the word '"+input+"' has been deleted at position "+posToBeDeleted+".");}
    }

}}

class removeAll implements ActionListener { //removes all of word in the list
    FilledFrames theApp;


    removeAll(FilledFrames app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        String input = theApp.inputText.getText();
        if(input.isEmpty()){JOptionPane.showMessageDialog(theApp,"Input cannot be empty.");}
        else{
            int pos = 0;
            LinkedList<String> survivors = new LinkedList<>(); //list for words that do not match
            boolean found = false;
            for (int i = 0; i < theApp.wordList.size(); i++){
                if(input.equals(theApp.wordList.get(i))){
                    found=true;

                }else{survivors.add(theApp.wordList.get(i));} //if no match put into separate list
            }
            if(found = false){theApp.largeTextBox.setText("There were no instances of the word '"+input+"' in the list."); theApp.inputText.setText("");}
            else{
                    theApp.wordList.clear();
                    theApp.wordList.addAll(survivors); //clears the initial list then adds all the values from temp list into it
                    theApp.largeTextBox.setText("All instances of the word '"+input+"' has been deleted."+"\n" +"Displaying updated list:"+"\n"+ CE203_2018_Ex2.setText(theApp.wordList));//couldn't figure out how to call the method without calling CE203_2018_Ex2
            }
    } }

}
class clearAll implements ActionListener { //clears the list
    FilledFrames theApp;

    clearAll(FilledFrames app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        theApp.wordList.clear();
        theApp.largeTextBox.setText("The list has been cleared! "+"\n"+CE203_2018_Ex2.setText(theApp.wordList));
    }
}

class showList implements ActionListener { // extra bit, displays the whole list in the console, was useful during debugging so it was left in
    FilledFrames theApp;

    showList(FilledFrames app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        theApp.inputText.setText("");
        theApp.largeTextBox.setText("Displaying the list: "+"\n"+CE203_2018_Ex2.setText(theApp.wordList));
    }

}







