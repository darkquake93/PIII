/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Sonya
 */
public class Frame extends JFrame{
    public Frame()
    {
        this.setLayout(new GridLayout(0,1));
        this.setSize(500, 300);
        this.setVisible(true);
    }
}
