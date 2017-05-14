/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.ui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Randula
 */
public class ShowPop extends JPopupMenu  {
    JMenuItem anItem;
    public ShowPop(){
        anItem = new JMenuItem("Delete");
        add(anItem);
    }
}

