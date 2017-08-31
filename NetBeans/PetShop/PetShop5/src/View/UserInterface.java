/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.PetShop;
import Controller.Reader;
import Controller.Writer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sonya
 */
public class UserInterface{
    private ArrayList<String> searchHistory = new Reader().getSearchHistory();
    
    public UserInterface()
    {
        final Reader petShopA5 = new Reader();
        Frame frame = new Frame();
        JLabel label = new JLabel("Enter a keyword");
        final JTextField searchBar = new JTextField();
        
        JButton btnSearch = new JButton("Search Stores");
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
            btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                Writer writer = new Writer(searchBar.getText()+"\n", "src/Files/searchHistory.csv", true);
                for(int i = 0; i < petShopA5.searchPetShop(searchBar.getText()).size(); i++)
                {
                    textArea.setText(textArea.getText()+petShopA5.searchPetShop(searchBar.getText()).get(i)+"\n");
                }
                searchBar.setText("");
            }
        });
        JButton btnRecover = new JButton("Recover Last Keyword/View Search History");
            btnRecover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchHistory = new Reader().getSearchHistory();
                searchBar.setText(searchHistory.get(searchHistory.size()-1));
                textArea.setText("");
                for(int i = searchHistory.size()-1; i > -1 ; i--)
                {
                    textArea.setText(textArea.getText()+"\n"+searchHistory.get(i));
                }
            }
        });
        JScrollPane scroll = new JScrollPane(textArea);
        JButton btnGetAllStores = new JButton("View All Stores");
            btnGetAllStores.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                ArrayList<PetShop> petShopList = new Reader().getAllStores();
                for(int i = 0; i < petShopList.size(); i++)
                {
                    textArea.setText(textArea.getText()+petShopList.get(i).toString()+"\n");
                }
            }
        });
        JButton btnExport = new JButton("Export");
            btnExport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Writer writer = new Writer(textArea.getText(), "src/Files/ExportFiles.csv", false);
            }
        });
        JButton btnAddToExportFile = new JButton("Add to File");
            btnAddToExportFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Writer writer = new Writer(textArea.getText(), "src/Files/ExportFiles.csv", true);
            }
        });    
        JButton btnViewTimes = new JButton("View Opening Times");
            btnViewTimes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<PetShop> petShopList = new Reader().getAllStores();
                for(int i = 0; i < petShopList.size(); i++)
                {
                    textArea.setText(textArea.getText()+"\n"+petShopList.get(i).getName()+"\n"+petShopList.get(i).getOpeningTimes()+"\n\n");
                }
            }
        });
            
        JTabbedPane pane = new JTabbedPane();
        JPanel panel = new JPanel();
            panel.add(btnSearch);
            panel.add(btnViewTimes);
        pane.addTab("Search Stores", panel);
        pane.addTab("Search Pet", new JLabel());
        pane.addTab("Search History", btnRecover);
        pane.addTab("Sort", new JLabel());
        
        frame.add(label);
        frame.add(searchBar);
        frame.add(pane);
        //frame.add(btnSearch);
        //frame.add(btnRecover);
        //frame.add(btnGetAllStores);
        //frame.add(btnViewTimes);
        frame.add(scroll);
        //frame.add(btnExport);
        //frame.add(btnAddToExportFile);
        frame.setVisible(true);
    }
}
