import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

public class FileSystemSimulation implements ActionListener{
        private JTextField textField;
        private JFrame f;
        private JTable tbl;
        private Map<String,JButton> btnList;
        private FileSystemSimulation(){
            f=new JFrame();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) screenSize.getWidth();
            int height = (int) screenSize.getHeight();
            f.setSize(width,height);
            f.setLayout(null);
            int btnHeight=2*f.getSize().height/20;

            textField =new JTextField(new GetCurrentPath().getPath());
            textField.setBounds(70,0,f.getSize().width-f.getSize().width/10,30);
            f.add(textField);

            JButton backBtn = new JButton("<");
            backBtn.setBounds(0,0,f.getSize().width/20,f.getSize().height/25);
            backBtn.setForeground(Color.white);
            backBtn.setBackground(Color.blue);
            backBtn.setFocusPainted(false);
            backBtn.addActionListener(this);
            f.add(backBtn);

            JButton goBtn = new JButton("GO");
            goBtn.setBounds(f.getSize().width-f.getSize().width/20,0,f.getSize().width/20,f.getSize().height/25);
            goBtn.setForeground(Color.white);
            goBtn.setBackground(Color.blue);
            goBtn.setFocusPainted(false);
            goBtn.addActionListener(this);
            f.add(goBtn);

            JPanel sidePanel=new JPanel();
            sidePanel.setLayout(null);
            sidePanel.setBounds(0,30,f.getSize().width/6,f.getSize().height);
            sidePanel.setBackground(Color.white);

            JLabel taskLabel =new JLabel("Task");
            taskLabel.setFont(new Font("Georgia(Body)", Font.BOLD, 14));
            taskLabel.setForeground(Color.blue);
            taskLabel.setBounds(0,30,f.getSize().width/6,f.getSize().height/20);
            f.add(taskLabel);

            btnList = new HashMap<>();
            btnList.put("newFileBtn",new JButton("New File"));
            btnList.get("newFileBtn").setBounds(0,btnHeight,f.getSize().width/6,f.getSize().height/20);

            btnList.put("newFolderBtn",new JButton("New Folder"));
            btnList.get("newFolderBtn").setBounds(0,btnHeight+f.getSize().height/20,f.getSize().width/6,f.getSize().height/20);


            btnList.put("deleteBtn",new JButton("Delete"));
            btnList.get("deleteBtn").setBounds(0,btnHeight+2*f.getSize().height/20,f.getSize().width/6,f.getSize().height/20);

            btnList.put("moveBtn",new JButton("Move"));
            btnList.get("moveBtn").setBounds(0,btnHeight+3*f.getSize().height/20,f.getSize().width/6,f.getSize().height/20);

            btnList.put("renameBtn",new JButton("Rename"));
            btnList.get("renameBtn").setBounds(0,btnHeight+4*f.getSize().height/20,f.getSize().width/6,f.getSize().height/20);

            btnList.put("copyBtn",new JButton("Copy"));
            btnList.get("copyBtn").setBounds(0,btnHeight+5*f.getSize().height/20,f.getSize().width/6,f.getSize().height/20);

            for(String key : btnList.keySet()){
                btnList.get(key).setBackground(Color.white);
                btnList.get(key).setFocusPainted(false);
                sidePanel.add(btnList.get(key));
                btnList.get(key).addActionListener(this);
            }

            tbl = new JTable();
            tbl.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int row = tbl.rowAtPoint(evt.getPoint());
                    int col = tbl.columnAtPoint(evt.getPoint());
                    if(evt.getClickCount()==2)
                        if (row >= 0 && col >= 0) {
                            if("Folder".equals(tbl.getValueAt(row,1))){
                                textField.setText(textField.getText()+"\\"+tbl.getValueAt(row,0));
                                updateTable(textField.getText());
                            }
                        }
                }
            });
            JScrollPane sp=new JScrollPane(tbl);
            sp.setBounds(f.getSize().width/6,30,f.getSize().width-f.getSize().width/6,f.getSize().height-30);
            updateTable(".");
            f.add(sp);

            f.add(sidePanel);
            f.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        public void actionPerformed(ActionEvent e) {
            String command = ((JButton)(e.getSource())).getText();
            int column = 0;
            int row = tbl.getSelectedRow();
            String selectedFile="";
            if(row>=0){
                selectedFile = tbl.getModel().getValueAt(row, column).toString();
            }
            switch (command){
                case "New File":
                        String fileName=JOptionPane.showInputDialog("Enter File name");
                        new NewFile().newFile(textField.getText()+"\\"+fileName);
                        updateTable(textField.getText());
                    break;

                case "New Folder":
                        String dirName=JOptionPane.showInputDialog("Enter Folder name");
                        new MakeDir().makeDir(textField.getText()+"\\"+dirName);
                        updateTable(textField.getText());
                    break;

                case "Delete":
                        new DeleteFile().deleteFile(textField.getText()+"\\"+selectedFile);
                        updateTable(textField.getText());
                    break;

                case "Rename":
                        String newFileName=JOptionPane.showInputDialog("Enter new file name");
                        new RenameFile().renameFile(textField.getText(),selectedFile,newFileName);
                        updateTable(textField.getText());
                    break;

                case "Copy":
                    JFileChooser chooserCopy = new JFileChooser();
                    chooserCopy.setCurrentDirectory(new java.io.File(textField.getText()));
                    chooserCopy.setDialogTitle("select folder");
                    chooserCopy.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    chooserCopy.showDialog(f,"Select");
                    new CopyFile().copyFile(textField.getText()+"\\"+selectedFile,chooserCopy.getSelectedFile().toString()+"\\"+selectedFile);
                    break;

                case "Move":
                    JFileChooser chooserMove = new JFileChooser();
                    chooserMove.setCurrentDirectory(new java.io.File(textField.getText()));
                    chooserMove.setDialogTitle("select folder");
                    chooserMove.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    chooserMove.showDialog(f,"Select");
                    new MoveFile().moveFile(textField.getText()+"\\"+selectedFile,chooserMove.getSelectedFile().toString()+"\\"+selectedFile);
                    updateTable(textField.getText());
                    break;
                case "<":
                    String tempPath=textField.getText();
                    int endPoint=tempPath.lastIndexOf('\\');
                    if(endPoint>2)
                        textField.setText(tempPath.substring(0,endPoint));
                    else
                        textField.setText(tempPath.substring(0,endPoint+1));
                case "GO":
                        updateTable(textField.getText());
                    break;

                default: JOptionPane.showMessageDialog(f, "Application malfunctioned, Contact developers");
            }
        }

        private void updateTable(String path) {
        try {
            ArrayList<CustFile> fileList = new ListAllFiles().listFile(path);

            MyTableModel dtm = new MyTableModel(0, 0);

            String header[] = new String[]{"Name", "Type", "Size"};

            dtm.setColumnIdentifiers(header);

            tbl.setModel(dtm);

            for (int count = 0; count < fileList.size(); count++) {
                dtm.addRow(fileList.get(count).getCustFile());
            }
            }
            catch (IOException e){System.err.print(e.getMessage());}
        }
        public static void main(String[] args) {
            new FileSystemSimulation();
        }
}
