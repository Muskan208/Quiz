import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quizcomplete extends JFrame implements ActionListener {
  JLabel L1;
  JRadioButton r0, r1, r2, r3;
  ButtonGroup grp;
  JButton b1, b2;
  JPanel mainPanel, questionPanel, optionPanel, controlPanel;

  String q[] = { "Q1.Grand Central Terminal, Park Avenue, New York is the world's",
      "Q2. Entomology is the science that studies",
      "Q3. Eritrea, which became the 182nd member of the UN in 1993, is in the continent of",
      "Q4. Garampani sanctuary is located at",
      "Q5. For which of the following disciplines is Nobel Prize awarded?"

  };
  String choice[][] = {
      { "A. largest railway station", "B. highest railway station", "C. longest railway station",
          "D. None of the above" },
      { "A. Behavior of human beings", "B. Insects",
          "C. The origin and history of technical and scientific terms", "D. The formation of rocks" },
      { "A. Asia", "B. Africa", "C. Europe", "D. Australia" },
      { "A. Junagarh, Gujarat", "B. Diphu, Assam", "C. Kohima, Nagaland", "D. Gangtok, Sikkim" },
      { "A. Physics and Chemistry", "B. Physiology or Medicine", "C. Literature, Peace and Economics",
          "D. All of the above" } };

  String ans[] = { "A", "B", "B", "B", "D" };
  int cnt = 0;
  int marks = 0;
  String uAns = "";
  String Name = "";
  
  public Quizcomplete() {
    this.setVisible(true);
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    L1 = new JLabel();
    r0 = new JRadioButton();
    r1 = new JRadioButton();
    r2 = new JRadioButton();
    r3 = new JRadioButton();
    grp = new ButtonGroup();
    b1 = new JButton("Cancel");
    b2 = new JButton("Next");
    mainPanel = new JPanel();
    questionPanel = new JPanel();
    optionPanel = new JPanel();
    controlPanel = new JPanel();
    grp.add(r0);
    grp.add(r1);
    grp.add(r2);
    grp.add(r3);
    mainPanel.setLayout(new BorderLayout());
    questionPanel.add(L1);
    mainPanel.add(questionPanel, "North");
    optionPanel.add(r0);
    optionPanel.add(r1);
    optionPanel.add(r2);
    optionPanel.add(r3);
    optionPanel.setLayout(new GridLayout(4, 1));
    mainPanel.add(optionPanel, "Center");
    controlPanel.add(b1);
    controlPanel.add(b2);
    mainPanel.add(controlPanel, "South");
    mainPanel.setBorder(BorderFactory.createTitledBorder("Quiz"));
    questionPanel.setBorder(BorderFactory.createTitledBorder("Question"));
    optionPanel.setBorder(BorderFactory.createTitledBorder("Options"));
    controlPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
    this.setSize(801, 600);
    this.add(mainPanel);
    b1.addActionListener(this);
    b2.addActionListener(this);
    Name = JOptionPane.showInputDialog(null, "Enter Name");
    this.setTitle("Canididate Name:" + Name);
    Show();
  }

  public void Show() {
    grp.clearSelection();
    L1.setText(q[cnt]);
    r0.setText(choice[cnt][0]);
    r1.setText(choice[cnt][1]);
    r2.setText(choice[cnt][2]);
    r3.setText(choice[cnt][3]);

  }

  public void actionPerformed(ActionEvent e) {
    JButton x = (JButton) e.getSource();

    if (x.getText().equals("Next")) {
      if (cnt < 3) {
        if (result()) {
          cnt++;
          Show();
        }
      } else {
        if (result()) {
          cnt++;
          Show();
          x.setText("Finish");
        }

      }
    }
    else if(x.getText().equals("Finish"))
    {
      if(result()){
        String msg = "Dear "+Name+"\n"+" your marks is "+marks+" out of 5";
        JOptionPane.showMessageDialog(null, msg);
        System.exit(0);
      }
    }

    else {
      System.exit(0);
    }

  }

public boolean result() {
    if (!r0.isSelected() && !r1.isSelected() && !r2.isSelected() && !r3.isSelected()) {
      JOptionPane.showMessageDialog(null, "select option", "Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    if (r0.isSelected())
      uAns = "A";
    if (r1.isSelected())
      uAns = "B";
    if (r2.isSelected())
      uAns = "C";
    if (r3.isSelected())
      uAns = "D";
    if (uAns.equals(ans[cnt])) {
      marks++;
      JOptionPane.showMessageDialog(null, "Correct Ans");
    } else {
      JOptionPane.showMessageDialog(null, "Incorrect Ans");
    }
    return true;
  }

  public static void main(String args[]) {
    new Quizcomplete();
  }

}
