import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager.LookAndFeelInfo;

//contains most graphical data
//welcome to hell

public class display extends JFrame {
    /*ppl keep saying static vars are bad and i mean thats probably true because of something something nerd stuff idk about but um im bad at coding and i keep
    having problems idk how to fix without static vars idek why theyre bad but um maybe one day ill be good at coding and it will be fixed*/

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
        frame.setSize(400, 400);

        //word display

        //make new panel this will have the words in it
        JPanel wordPanel = new JPanel();
        wordPanel.setLayout(new BoxLayout(wordPanel, BoxLayout.Y_AXIS));

        // Create a JScrollPane and add the content panel to it
        JScrollPane wordDisplay = new JScrollPane(wordPanel);
        wordDisplay.setBounds(200, 25, 175, 375);

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


        //label for word length
        JLabel lengthLabel = new JLabel("Word Length");
        lengthLabel.setBounds(25, 25, 150, 25);
        panel.add(lengthLabel);

        //label for consonant
        JLabel vowelLabel = new JLabel("Vowel Distance");
        vowelLabel.setBounds(25, 50, 150, 25);
        panel.add(vowelLabel);



        //DROPDOWNS



        //array vars (dropdown options)


        //for op dropdowns
        String[] operators = {"=","<", "Any"};

        String[] letters = {"Any Vowel","Any Consonant","Any Letter", "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


        //filter dropdowns


        //dropdown for operator on word length
        final JComboBox<String> lengthOperator = new JComboBox<>(operators);
        lengthOperator.setBounds(74, 25,  50, 25);
        panel.add(lengthOperator);

        //dropdown for operator on vowel space
        final JComboBox<String> vowelOperator = new JComboBox<>(operators);
        vowelOperator.setBounds(125, 50,  50, 25);
        panel.add(vowelOperator);

        //dropdown for first letter
        final JComboBox<String> startingLetter = new JComboBox<>(letters);
        startingLetter.setBounds(125, 75,  50, 25);
        panel.add(startingLetter);


        //filter fields


        //field for word length
        JTextField lengthField = new JTextField("0");
        lengthField.setBounds(134, 25, 25, 25);
        panel.add(lengthField);

        //field for vowel
        JTextField vowelField = new JTextField("0");
        vowelField.setBounds(175, 50, 25, 25);
        panel.add(vowelField);


        ///BUTTONS


        //button to run word calcs
        JButton run = new JButton("Generate");
        run.setBounds(25, 175, 100, 25);
        panel.add(run);


        //ACTIONS

        //calculates words (run button)
        run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel result = new JLabel(gen.generate(Integer.parseInt((String)lengthField.getText()), Integer.parseInt((String)vowelField.getText()), (String)startingLetter.getSelectedItem()));
                wordPanel.add(result);       
            }
        });


    }
}