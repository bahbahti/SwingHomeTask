package MyListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Programm.Swing;

public class ActionListenerList3 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame jFrame = new JFrame("here the list of published amount");
        jFrame.setPreferredSize(new Dimension(400, 150));
        jFrame.setLocation(850, 300);

        JTextArea jTextArea = new JTextArea();
        Font font = new Font("Aerials", 9, 16);
        jTextArea.setFont(font);
        String str ="";
        jTextArea.append("Book1: ");
        for (int i = 0; i < Swing.bmt.getRowCount(); i++) {
            str = Swing.bmt.getValueAt(i, 3).toString();
            jTextArea.append(str);
            if(i != Swing.bmt.getRowCount() - 1) {
                jTextArea.append(", Book" + (i + 2) + ": ");
            }
        }
        jTextArea.setEditable(false);
        jFrame.add(jTextArea);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}