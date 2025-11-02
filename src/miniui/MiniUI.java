package miniui;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class MiniUI {
    
    public static JFrame createWindow() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize((int) (screenSize.getWidth() / 1.1),(int) (screenSize.getHeight() / 1.1));
        //window.setExtendedState(JFrame.MAXIMIZED_BOTH); // sets screen to full screen
        return window;
    }
    
    public static void createMenuBar(JFrame window) {
        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.WHITE);
        // file icon
        
        JMenu file = new JMenu("File");
        
        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        
        file.add(load);
        file.add(save);
        file.add(exit);
        
        // edit icon
        
        JMenu edit = new JMenu("Edit");
        
        // help icon
        
        JMenu help = new JMenu("Help");
        
        // adding icons to menu bar
        
        menu.add(file);
        menu.add(edit);
        menu.add(help);
        
        window.setJMenuBar(menu);
    }
    
    public static void createTopBar(JFrame window) {
        JPanel topbar = new JPanel();
        //topbar.setBackground(Color.LIGHT_GRAY);
        topbar.setLayout(new FlowLayout(FlowLayout.CENTER,10,28));
        window.add(topbar,BorderLayout.NORTH);
    }
    
    public static DefaultMutableTreeNode createBasicComponents() {
        DefaultMutableTreeNode basicComponents = new DefaultMutableTreeNode("Core");
        
        DefaultMutableTreeNode and = new DefaultMutableTreeNode("AND");
        DefaultMutableTreeNode or = new DefaultMutableTreeNode("OR");
        DefaultMutableTreeNode nand = new DefaultMutableTreeNode("NAND");
        DefaultMutableTreeNode xor = new DefaultMutableTreeNode("XOR");
        DefaultMutableTreeNode xnor = new DefaultMutableTreeNode("XNOR");
        DefaultMutableTreeNode not = new DefaultMutableTreeNode("NOT");
        
        basicComponents.add(and);
        basicComponents.add(or);
        basicComponents.add(not);
        basicComponents.add(nand);
        basicComponents.add(xor);
        basicComponents.add(xnor);
        
        return basicComponents;
    }
    
    public static DefaultMutableTreeNode createCommonComponents() {
        DefaultMutableTreeNode commonComponents = new DefaultMutableTreeNode("Common");
            
        DefaultMutableTreeNode adder = new DefaultMutableTreeNode("ADDER");
        DefaultMutableTreeNode subtractor = new DefaultMutableTreeNode("SUBTRACTOR");
        DefaultMutableTreeNode splitter = new DefaultMutableTreeNode("SPLITTER");
        DefaultMutableTreeNode memory = new DefaultMutableTreeNode("MEMORY");
        
        commonComponents.add(adder);
        commonComponents.add(subtractor);
        commonComponents.add(splitter);
        commonComponents.add(memory);
        
        return commonComponents;
    }
    
    public static DefaultMutableTreeNode createMiscComponents() {
        DefaultMutableTreeNode miscComponents = new DefaultMutableTreeNode("Misc");
        
        DefaultMutableTreeNode led = new DefaultMutableTreeNode("LED");
        DefaultMutableTreeNode probe = new DefaultMutableTreeNode("PROBE");
        
        miscComponents.add(led);
        miscComponents.add(probe);
        
        return miscComponents;
    }
    
    public static DefaultMutableTreeNode createUserComponents() {
        DefaultMutableTreeNode userDefined = new DefaultMutableTreeNode("Custom");
        DefaultMutableTreeNode err = new DefaultMutableTreeNode("");
        userDefined.add(err);
        return userDefined;
    }
    
    public static Panel creatSidePanel(JFrame window) {
        
        String[] basicCompList = {"AND","OR","NOT","NAND","XOR","XNOR"};
        String[] commonCompList = {"ADDER","SUBTRACTOR","SPLITTER","MEMORY"};
        String[] miscCompList = {"LEDOR","PROBE"};
        
        Panel panel = new Panel(); 
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(200,100));
        
        DefaultMutableTreeNode miniCircuits = new DefaultMutableTreeNode("Mini_Circuits");
        DefaultMutableTreeNode basicComponents = createBasicComponents();
        DefaultMutableTreeNode common = createCommonComponents();
        DefaultMutableTreeNode userDefined = createUserComponents();
        DefaultMutableTreeNode misc = createMiscComponents();
        
        miniCircuits.add(basicComponents);
        miniCircuits.add(common);
        miniCircuits.add(userDefined);
        miniCircuits.add(misc);
        
        JTree fileTree = new JTree(miniCircuits);
        fileTree.setBounds(25,25,200,200);
        
        fileTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object object = e.getPath().getLastPathComponent(); 
                if (object instanceof DefaultMutableTreeNode){ 
                    DefaultMutableTreeNode selected = (DefaultMutableTreeNode) object; 
                    
                    for (int i = 0; i < basicCompList.length; i++) {
                        if (selected.toString().equals(basicCompList[i])) {
                            System.out.println(selected.toString());
                        }
                    }
                    
                    for (int i = 0; i < commonCompList.length; i++) {
                        if (selected.toString().equals(commonCompList[i])) {
                            System.out.println(selected.toString());
                        }
                    }
                    
                    for (int i = 0; i < miscCompList.length; i++) {
                        if (selected.toString().equals(miscCompList[i])) {
                            System.out.println(selected.toString());
                        }
                    }
                }
            }
        });
        
        panel.add(fileTree,BorderLayout.WEST);
        
        return panel;
    }
    
    public static Panel createCircuitArea(JFrame window) {
        Panel pane2 = new Panel();
        pane2.setBackground(Color.WHITE);
        return pane2;
    }
    
    public static void createMain(JFrame window) {
        // contains file structure for all of the circuit components as well as area to place circuit
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,creatSidePanel(window),createCircuitArea(window));
        window.getContentPane().add(splitPane);
    }
   
    public static void initialiseUI() {
        JFrame window = createWindow();
        createMenuBar(window);
        createTopBar(window);
        createMain(window);
        createCircuitArea(window);
        window.setVisible(true);
    }
    
    public static void main(String[] args) { 
        initialiseUI();
    }
}
