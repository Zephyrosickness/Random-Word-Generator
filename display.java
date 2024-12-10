import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager.LookAndFeelInfo;


//contains most graphical data
//welcome to hell

public class display extends JFrame {
    /*ppl keep saying static vars are bad and i mean thats probably true because of something something nerd stuff idk about but um im bad at coding and i keep
    having problems idk how to fix without static vars idek why theyre bad but um maybe one day ill be good at coding and it will be fixed*/

    public static int frameWid = 500;
    public static int frameHeight = 400;
    public static int margins = 10; // i asked santa for some variables and he gave me these

    public static void main(String[] args) {

        //changes l&f to windows classic because im a basic bitch like that
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            //error handler for l&f in case something doesnt work
            System.out.println("error with look and feel");
        }

        // create a window
        JFrame frame = new JFrame("word generator");
        frame.setSize(frameWid, frameHeight);

        //word display

        //make new panel this will have the words in it
        JPanel wordPanel = new JPanel();
        wordPanel.setLayout(new BoxLayout(wordPanel, BoxLayout.Y_AXIS));

        // Create a JScrollPane and add the content panel to it
        JScrollPane wordDisplay = new JScrollPane(wordPanel);
        int displayWid = (frameWid / 2) - (margins * 2);
        int displayHeight = frameHeight - (margins * 2);
        wordDisplay.setBounds((frameWid / 2) - margins, margins, displayWid, displayHeight);

        // Add the scroll pane to the frame
        frame.add(wordDisplay);

        //main panel to hold components
        JPanel panel = new JPanel();

        //adds panel
        frame.add(panel);
        panel.setBounds(0, 0, 200, 400);
        frame.setResizable(false);
        songInfoComponents(panel, wordPanel);
        frame.setVisible(true);
    }

    //panel to hold components
    public static void songInfoComponents(JPanel panel, JPanel wordPanel) {

        // set the layout manager to null for absolute positioning
        panel.setLayout(null);


        //filter option labels

        int queryHeight = 25;
        int halfOne = ((((frameWid / 2)-(margins * 2))/3));
        int halfTwo = (halfOne * 2);
        // santa please i have enough variables i do not want them for my birthday also oh geez

        //System.out.println("Test 1: " + halfOne);
        //System.out.println("Test 2: " + halfTwo);
        //System.out.println("Test 3: " + halfThree);
        //System.out.println("Test 4: " + frameWid);
        //System.out.println("Test 5: " + margins); // the hoarde

        //label for word length
        JLabel lengthLabel = new JLabel("Word Length");
        lengthLabel.setBounds(margins, margins, halfOne, queryHeight);
        panel.add(lengthLabel);

        //label for consonant
        JLabel vowelLabel = new JLabel("Vowel Distance");
        vowelLabel.setBounds(margins, (margins + queryHeight), halfOne, queryHeight);
        panel.add(vowelLabel);

        //label for first letter
        JLabel startLabel = new JLabel("First Letter");
        startLabel.setBounds(margins, (margins + (queryHeight*2)), halfOne, queryHeight);
        panel.add(startLabel);

        //DROPDOWNS


        //array vars (dropdown options)


        //for op dropdowns
        String[] operators = {"=","<", "Any"};

        String[] letters = {"Any Letter","Any Consonant","Any Vowel", "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


        //filter dropdowns

        int moveForward = (margins + halfOne);
        int moveForward2 = (margins + halfTwo);

        //dropdown for operator on word length
        final JComboBox<String> lengthOperator = new JComboBox<>(operators);
        lengthOperator.setBounds(moveForward, margins,  halfOne, queryHeight);
        panel.add(lengthOperator);

        //dropdown for operator on vowel space
        final JComboBox<String> vowelOperator = new JComboBox<>(operators);
        vowelOperator.setBounds(moveForward, (margins + queryHeight),  halfOne, queryHeight);
        panel.add(vowelOperator);

        //dropdown for first letter
        final JComboBox<String> startingLetter = new JComboBox<>(letters);
        startingLetter.setBounds(moveForward, (margins + (queryHeight*2)),  halfTwo, queryHeight);
        panel.add(startingLetter);

        //dropdown for uncommon letters boolean
        final JCheckBox uncommonCheck = new JCheckBox("Uncommon Letters?");
        uncommonCheck.setBounds(moveForward, (margins + (queryHeight*3)),  halfTwo, queryHeight);
        panel.add(uncommonCheck);

        //dropdown for adding "ing" boolean
        final JCheckBox ingCheck = new JCheckBox("Append 'ING'?");
        ingCheck.setBounds(moveForward, (margins + (queryHeight*4)),  halfTwo, queryHeight);
        panel.add(ingCheck);

        // NUMBERS sorry i removed the old comment here so im making my own

        //field for word length
        JTextField lengthField = new JTextField("0");
        lengthField.setBounds(moveForward2, margins, halfOne, queryHeight);
        panel.add(lengthField);

        //field for vowel
        JTextField vowelField = new JTextField("0");
        vowelField.setBounds(moveForward2, (margins + queryHeight), halfOne, queryHeight);
        panel.add(vowelField);


        //BUTTONS


        //button to run word calcs
        JButton run = new JButton("Generate");
        run.setFont(new Font("Arial", Font.PLAIN, 20));
        run.setBackground(new Color(255,255,255));
        //run.setForeground(new Color(0,0,0));
        run.setBorder(BorderFactory.createDashedBorder(Color.black, 2, 3));

        int newWidth = (frameWid / 2) - (margins * 3);

        run.setBounds(margins, frameHeight - 145, newWidth, 100);
        panel.add(run);


        //ACTIONS

        //calculates words (run button)
        //if this gives some kind of error about "experimental java features" change the underscore to "e" (no quotation marks)
        run.addActionListener(_ -> {
                JLabel result = new JLabel(gen.generate(Integer.parseInt(lengthField.getText()), Integer.parseInt(vowelField.getText()), (String)startingLetter.getSelectedItem(), (String)lengthOperator.getSelectedItem(), (String)vowelOperator.getSelectedItem(), uncommonCheck.isSelected(), ingCheck.isSelected()));
                // santa why is your accursed result 331 characters long
                //he just really likes adding on letters
            System.out.println(result.getText());
                wordPanel.add(result);
                wordPanel.repaint();
                wordPanel.revalidate();
        });

    }
}