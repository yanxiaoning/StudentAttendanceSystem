package sas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame {
	
	private JPanel desktop;
	private JPanel fr11;
	private JComboBox<String> box0;
	private JButton vcd;
	private JButton vh;
	private JComboBox<String> box1;
	private JComboBox<String> box2;
	private JComboBox<String> box3;
	private JButton attend;
	private JButton absent;
	private JScrollPane fr2;
	private JPanel fr10;
	private JPanel fr101;
	private JTextField txsId;
	private JTextField txsName;
	private JButton addStudent;
	private JTextField txcId;
	private JButton addCourse;
	private JTextField txcName;
	private JPanel fr102;
	private JComboBox<String> boxStudent;
	private JComboBox<String> boxCourse;
	private JButton deleteStudent;
	
	private JButton deleteCourse;
	private MyFrame myFrame;
	
	private JComboBox<String> boxCourse2;
	private DefaultComboBoxModel<String> modelCourse;
	private JPanel fr103;
	private DefaultComboBoxModel<String> modelStudent;
	private JButton jbtDeleteStudentTotally;
	private JComboBox<String> boxDeleteStudentTotally;
	private JComboBox<String> boxAddStudentToCourse;
	private JComboBox<String> boxCourseForStudentToAdd;
	private JButton jbtAddStudentToCourse;
	private JTable table;
	private JButton jbtAttend;
	private JButton jbtAbsent;
	private CourseManager cm;
	private StudentManager sm;

	public void establish()
	{
		myFrame = this;
		setLayout(new BorderLayout());
		setSize(1200, 900);
		 setTitle("Attendence Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cm = new CourseManager();
		sm = new StudentManager();
		
		
		desktop = new JPanel();
		desktop.setLayout(new BorderLayout(25,25));
	    


		
		
		
		
	    fr11 = new JPanel();
	    
	    fr11.setLayout(new FlowLayout());
	    
	    
	    fr11.add(new JLabel("View:"));
	    box0 = new JComboBox<String>();
	    modelCourse = new DefaultComboBoxModel<String>();
	    
	    ArrayList<String> listTemp7 = cm.getCourseList();
	    for(int i = 0; i < listTemp7.size(); i++)
	    	modelCourse.addElement(listTemp7.get(i));


	    box0.setModel(modelCourse);
	    box0.repaint();
	    box0.updateUI();
	    
	    
	    fr11.add(box0);
	    fr11.add(new JLabel("  "));
	    vcd = new JButton("View Course Detail");
	    vcd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				tableUpdate();
				
				
			}
	    	
	    });
	    fr11.add(vcd);
	    fr11.add(new JLabel("  "));
	    vh = new JButton("View Histogram");
	    vh.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String s = (String)box0.getSelectedItem();
				MyPanel jf=new MyPanel((cm.getRateList(s.substring(0, s.indexOf(" ")))));
				myFrame.setEnabled(false);
				jf.setVisible(true);
				jf.setBounds(800, 400, 600, 600);
				jf.addWindowListener(new WindowListener(){

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						myFrame.setEnabled(true);
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
			}
	    	
	    });
	    fr11.add(vh);
	    fr11.add(new JLabel("          "));
	    fr11.add(new JLabel("          "));
	    fr11.add(new JLabel("          "));
	    fr11.add(new JLabel("          "));
	    
	    jbtAttend = new JButton("Attend");
	    jbtAttend.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				String c = (String)box0.getSelectedItem();
						String cId = c.substring(0, c.indexOf(" "));
				int selectedRow = table.getSelectedRow();
				if(selectedRow == -1)
				{
					JOptionPane.showMessageDialog(null, "Please choose a record cell");
					
					return;
				}
				DefaultTableModel modelTemp = (DefaultTableModel) table.getModel();
				
				
				String sId = (String)modelTemp.getValueAt(selectedRow, 0);
				
				int selectedColumn = table.getSelectedColumn();
				if(!((String)(modelTemp.getValueAt(selectedRow, selectedColumn))).equals("attend")&&!((String)(modelTemp.getValueAt(selectedRow, selectedColumn))).equals("ABSENT")&&!((String)(modelTemp.getValueAt(selectedRow, selectedColumn))).equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please choose valid cell");
					return;
				}
						
				cm.UpdateAttendenceDetailCellTo_Attend(cId, sId, selectedColumn);
			
				tableUpdate();
				
			}
	    	
	    });
	    fr11.add(jbtAttend);
	    jbtAbsent = new JButton("Absent");
	    jbtAbsent.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String c = (String)box0.getSelectedItem();
				String cId = c.substring(0, c.indexOf(" "));
		int selectedRow = table.getSelectedRow();
		if(selectedRow == -1)
		{
			JOptionPane.showMessageDialog(null, "Please choose a record cell");
			
			return;
		}
		DefaultTableModel modelTemp = (DefaultTableModel) table.getModel();
		String sId = (String)modelTemp.getValueAt(selectedRow, 0);
		int selectedColumn = table.getSelectedColumn();
		if(!((String)(modelTemp.getValueAt(selectedRow, selectedColumn))).equals("attend")&&!((String)(modelTemp.getValueAt(selectedRow, selectedColumn))).equals("ABSENT")&&!((String)(modelTemp.getValueAt(selectedRow, selectedColumn))).equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please choose valid cell");
			return;
		}
		cm.UpdateAttendenceDetailCellTo_Absent(cId, sId, selectedColumn);
	
			tableUpdate();
			
			}
	    	
	    });
	    fr11.add(jbtAbsent);
	    
	    
	    
	    
	    desktop.add(fr11, BorderLayout.SOUTH);//zan
	    
	    
	    table = new JTable();
	   
	    
	    
	    fr2 = new JScrollPane(table);
	     fr2.setBorder(new TitledBorder("Display Area"));
	    desktop.add(fr2, BorderLayout.CENTER);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    fr10 = new JPanel();
	    fr10.setLayout(new GridLayout(6,1));
	    
	    fr101 = new JPanel();
	    fr101.setLayout(new GridLayout(1,11));
	    fr101.add(new JLabel("studentID:"));
	    txsId = new JTextField();
	    fr101.add(txsId);
	    fr101.add(new JLabel("Name:"));
	    txsName = new JTextField();
	    fr101.add(txsName);
	    addStudent = new JButton("AddStudent");
	    addStudent.addActionListener(new ActionListener(){
	    	

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String sId = txsId.getText().toString();
				String sName = txsName.getText().toString();
				
if(sId.isEmpty()||sName.isEmpty())
					
				{
					JOptionPane.showMessageDialog(null, "Null is not allowed!");
				return;
				}



boolean exist = false;
ArrayList<String> list = sm.getStudentList();
for(int i = 0;i < list.size();i++)
{
	String s = list.get(i);
	if(s.substring(0,s.indexOf(" ")).equals(sId))
	{
		exist = true;
		break;
	}
}
if(exist)
{
	JOptionPane.showMessageDialog(null, "Duplicated Student!");
	
return;
}


				if(sId.equals(null)||sId.equals("")||sName.equals(null)||sName.equals(""))
				{
				/////Hint
				}
				else{	
				
				sm.addStudent(sId,sName);
				
	///////////////
					modelStudent = new DefaultComboBoxModel<String>();
				    ArrayList<String> listTemp2 = sm.getStudentList();
				    
				    for(int i = 0;i < listTemp2.size();i++)
				    	modelStudent.addElement(listTemp2.get(i));
				    
				    boxDeleteStudentTotally.setModel(modelStudent);
				    boxDeleteStudentTotally.repaint();
				    boxDeleteStudentTotally.updateUI();
					
					///////////////////
				    modelStudent = new DefaultComboBoxModel<String>();
				    
				    ArrayList<String> listTemp5 = sm.getStudentList();
				    for(int i = 0; i < listTemp5.size(); i++)
				    	modelStudent.addElement(listTemp5.get(i));


				    boxAddStudentToCourse.setModel(modelStudent);
				    boxAddStudentToCourse.repaint();
				    boxAddStudentToCourse.updateUI();
				    ///////////////
				    JOptionPane.showMessageDialog(null, "Student Added Successfully!");
				    
				    
				}
			}
	    });
	    
	    fr101.add(addStudent);
	    fr101.add(new JLabel("          "));
	    fr101.add(new JLabel("courseID:"));
	    txcId = new JTextField();
	    fr101.add(txcId);
	    fr101.add(new JLabel("Name:"));
	    txcName = new JTextField();
	    fr101.add(txcName);
	    addCourse = new JButton("AddCourse");
	    addCourse.addActionListener(new ActionListener(){
	    	

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				
				
				String cId = txcId.getText().toString();
				String cName = txcName.getText().toString();
				
				if(cId.isEmpty()||cName.isEmpty())
					
				{
					JOptionPane.showMessageDialog(null, "Null is not allowed!");
				return;
				}
						
				
				boolean exist = false;
				
				ArrayList<String> list = cm.getCourseList();
				for(int i = 0;i < list.size();i++)
				{
					String s = list.get(i);
					if(s.substring(0,s.indexOf(" ")).equals(cId))
					{
						exist = true;
						break;
					}
				}
				if(exist)
				{
					JOptionPane.showMessageDialog(null, "Duplicated Course!");
					
				return;
				}
				
				if(cId.equals(null)||cId.equals("")||cName.equals(null)||cName.equals(""))
				{
				/////Hint
				}
				else{	
			
				cm.addCourse(cId,cName);
				////////////////////////
				modelCourse = new DefaultComboBoxModel<String>();
				    
				    ArrayList<String> listTemp = cm.getCourseList();
				    for(int i = 0; i < listTemp.size(); i++)
				    	modelCourse.addElement(listTemp.get(i));


				    boxCourse2.setModel(modelCourse);
				    boxCourse2.repaint();
				    boxCourse2.updateUI();
				    ////////////////////////////
				    ArrayList<String> listTemp3 = cm.getCourseList();
				    modelCourse = new DefaultComboBoxModel<String>();
				    for(int i = 0;i < listTemp3.size();i++)
				    	modelCourse.addElement(listTemp3.get(i));
				    
				    boxCourse.setModel(modelCourse);
				    boxCourse.repaint();
				    boxCourse.updateUI();
				    //////////////////
				    modelStudent = new DefaultComboBoxModel<String>();
				    String s = (String)boxCourse.getSelectedItem();
				    ArrayList<String> listTemp4 = cm.getStudentsFromCourse(s.substring(0, s.indexOf(" ")));
				    for(int i = 0;i < listTemp4.size();i++)
				    	modelStudent.addElement(listTemp4.get(i));
				    
				    boxStudent.setModel(modelStudent);
				    boxStudent.repaint();
				    boxStudent.updateUI();
				    ////////////////////////////////////
				    modelCourse = new DefaultComboBoxModel<String>();
				    
				    ArrayList<String> listTemp6 = cm.getCourseList();
				    for(int i = 0; i < listTemp6.size(); i++)
				    	modelCourse.addElement(listTemp6.get(i));


				    boxCourseForStudentToAdd.setModel(modelCourse);
				    boxCourseForStudentToAdd.repaint();
				    boxCourseForStudentToAdd.updateUI();
				    /////////////////
				    modelCourse = new DefaultComboBoxModel<String>();
				    
				    ArrayList<String> listTemp7 = cm.getCourseList();
				    for(int i = 0; i < listTemp7.size(); i++)
				    	modelCourse.addElement(listTemp7.get(i));


				    box0.setModel(modelCourse);
				    box0.repaint();
				    box0.updateUI();
				    /////////////////
				    tableUpdate();
				    //////
				    JOptionPane.showMessageDialog(null, "Course Added Successfully!");
				    
				}
				
			}
	    });
	    fr101.add(addCourse);
	    
	    
	    
	    
	    
	    
	    fr102 = new JPanel();
	    fr102.setLayout(new GridLayout(1,5));
	   
	    boxCourse = new JComboBox<String>();
	    ArrayList<String> listTemp3 = cm.getCourseList();
	    modelCourse = new DefaultComboBoxModel<String>();
	    for(int i = 0;i < listTemp3.size();i++)
	    	modelCourse.addElement(listTemp3.get(i));
	    
	    boxCourse.setModel(modelCourse);
	    boxCourse.repaint();
	    boxCourse.updateUI();
	    boxCourse.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange() == ItemEvent.SELECTED)
				{
					modelStudent = new DefaultComboBoxModel<String>();
				    String s = (String)boxCourse.getSelectedItem();
				    
				    ArrayList<String> listTemp4 = cm.getStudentsFromCourse(s.substring(0, s.indexOf(" ")));
				    for(int i = 0;i < listTemp4.size();i++)
				    	modelStudent.addElement(listTemp4.get(i));
				    
				    boxStudent.setModel(modelStudent);
				    boxStudent.repaint();
				    boxStudent.updateUI();
				}
			}
	    	
	    });
	    
    	fr102.add(boxCourse);
    	
    	
	    boxStudent = new JComboBox<String>();
	    
	    modelStudent = new DefaultComboBoxModel<String>();
	    String s = (String)boxCourse.getSelectedItem();
	    ArrayList<String> listTemp4 = cm.getStudentsFromCourse(s.substring(0, s.indexOf(" ")));
	    for(int i = 0;i < listTemp4.size();i++)
	    	modelStudent.addElement(listTemp4.get(i));
	    
	    boxStudent.setModel(modelStudent);	
	    boxStudent.repaint();
	    boxStudent.updateUI();
	    
	    fr102.add(boxStudent);
	    
	    deleteStudent = new JButton("Delete Student from course");
	    
	    deleteStudent.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String s1 = (String)boxStudent.getSelectedItem();
				String s2 = (String)boxCourse.getSelectedItem();
				if(s1 == null||s1 == ""||s2 == null||s2 == "")
				{
					JOptionPane.showMessageDialog(null, "Null delete!");
				    
					return;
				}
				
				 
				cm.deleteStudentFromCourse(s1.substring(0, s1.indexOf(" ")), s2.substring(0, s2.indexOf(" ")));
			
			
				 modelStudent = new DefaultComboBoxModel<String>();
				    String s = (String)boxCourse.getSelectedItem();
				    ArrayList<String> listTemp4 = cm.getStudentsFromCourse(s.substring(0, s.indexOf(" ")));
				    for(int i = 0;i < listTemp4.size();i++)
				    	modelStudent.addElement(listTemp4.get(i));
				    
				    boxStudent.setModel(modelStudent);
				    boxStudent.repaint();
				    boxStudent.updateUI();
				    ///////////////////
				    tableUpdate();
				    //////
				    JOptionPane.showMessageDialog(null, "Student Deleted Successfully!");
				    
			}
	    	
	    });
	    fr102.add(deleteStudent);
	    fr102.add(new JLabel("          "));
	    
	    
	    
	    
		
	    boxCourse2 = new JComboBox<String>();
	    modelCourse = new DefaultComboBoxModel<String>();
	    
	    ArrayList<String> listTemp = cm.getCourseList();
	    for(int i = 0; i < listTemp.size(); i++)
	    	modelCourse.addElement(listTemp.get(i));


	    boxCourse2.setModel(modelCourse);
	    boxCourse2.repaint();
	    boxCourse2.updateUI();
	   
	    fr102.add(boxCourse2);
	    deleteCourse = new JButton("DeleteCourse");
	    deleteCourse.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(boxCourse2.getModel().getSize() == 1)
				{
					JOptionPane.showMessageDialog(null, "Only one course left ,cannot be deleted");
				return;
				}
				
				
				String s = boxCourse2.getSelectedItem().toString();
				int indexOfSpace = s.indexOf(" ");
				
				
				cm.deleteCourse(s.substring(0,indexOfSpace));
				
				
				///////////////
				modelCourse = new DefaultComboBoxModel<String>();
				    
				    ArrayList<String> listTemp = cm.getCourseList();
				    for(int i = 0; i < listTemp.size(); i++)
				    	modelCourse.addElement(listTemp.get(i));


				    boxCourse2.setModel(modelCourse);
				    boxCourse2.repaint();
				    boxCourse2.updateUI();
				
////////////////////////////
			    ArrayList<String> listTemp3 = cm.getCourseList();
			    modelCourse = new DefaultComboBoxModel<String>();
			    for(int i = 0;i < listTemp3.size();i++)
			    	modelCourse.addElement(listTemp3.get(i));
			    
			    boxCourse.setModel(modelCourse);
			    boxCourse.repaint();
			    boxCourse.updateUI();
			    //////////////////
			    modelStudent = new DefaultComboBoxModel<String>();
			    String s2 = (String)boxCourse.getSelectedItem();
			    ArrayList<String> listTemp4 = cm.getStudentsFromCourse(s2.substring(0, s2.indexOf(" ")));
			    for(int i = 0;i < listTemp4.size();i++)
			    	modelStudent.addElement(listTemp4.get(i));
			    
			    boxStudent.setModel(modelStudent);
			    boxStudent.repaint();
			    boxStudent.updateUI();
			    ////////////////////////////////////
			    modelCourse = new DefaultComboBoxModel<String>();
			    
			    ArrayList<String> listTemp6 = cm.getCourseList();
			    for(int i = 0; i < listTemp6.size(); i++)
			    	modelCourse.addElement(listTemp6.get(i));


			    boxCourseForStudentToAdd.setModel(modelCourse);
			    boxCourseForStudentToAdd.repaint();
			    boxCourseForStudentToAdd.updateUI();
			    ////////////////////////////////////////////
			    modelCourse = new DefaultComboBoxModel<String>();
			    
			    ArrayList<String> listTemp7 = cm.getCourseList();
			    for(int i = 0; i < listTemp7.size(); i++)
			    	modelCourse.addElement(listTemp7.get(i));


			    box0.setModel(modelCourse);
			    box0.repaint();
			    box0.updateUI();
			    //////////////////////////////////////////////
///////////////////
				    tableUpdate();
				    //////
			    JOptionPane.showMessageDialog(null, "Course Deleted Successfully!");
			    
						
			}
	    	
	    });
	    fr102.add(deleteCourse);
	   
	    
	    
	    fr103 = new JPanel();
	    fr103.setLayout(new GridLayout(1,7));
	    boxDeleteStudentTotally = new JComboBox<String>();
	    
	    
	    modelStudent = new DefaultComboBoxModel<String>();
	    ArrayList<String> listTemp2 = sm.getStudentList();
	    
	    for(int i = 0;i < listTemp2.size();i++)
	    	modelStudent.addElement(listTemp2.get(i));
	    
	    boxDeleteStudentTotally.setModel(modelStudent);
	    boxDeleteStudentTotally.repaint();
	    boxDeleteStudentTotally.updateUI();
	    fr103.add(boxDeleteStudentTotally);
	    
	    jbtDeleteStudentTotally = new JButton("Delete Student");
	    jbtDeleteStudentTotally.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String s = (String)boxDeleteStudentTotally.getSelectedItem();
				
				if(s == null||s == "")
				{
					JOptionPane.showMessageDialog(null, "Null delete!");
				             return;
				}
				
				int indexOfSpace = s.indexOf(" ");
				
				
				sm.deleteStudent(s.substring(0,indexOfSpace));
				
				
				///////////////
				modelStudent = new DefaultComboBoxModel<String>();
			    ArrayList<String> listTemp2 = sm.getStudentList();
			    
			    for(int i = 0;i < listTemp2.size();i++)
			    	modelStudent.addElement(listTemp2.get(i));
			    
			    boxDeleteStudentTotally.setModel(modelStudent);
			    boxDeleteStudentTotally.repaint();
			    boxDeleteStudentTotally.updateUI();
				
				///////////////////
			    modelStudent = new DefaultComboBoxModel<String>();
			    String s2 = (String)boxCourse.getSelectedItem();
			    
			    ArrayList<String> listTemp4 = cm.getStudentsFromCourse(s2.substring(0, s2.indexOf(" ")));
			    for(int i = 0;i < listTemp4.size();i++)
			    	modelStudent.addElement(listTemp4.get(i));
			    
			    boxStudent.setModel(modelStudent);
			    boxStudent.repaint();
			    boxStudent.updateUI();
			    ////////////////////////////////////
			    modelStudent = new DefaultComboBoxModel<String>();
			    
			    ArrayList<String> listTemp5 = sm.getStudentList();
			    for(int i = 0; i < listTemp5.size(); i++)
			    	modelStudent.addElement(listTemp5.get(i));


			    boxAddStudentToCourse.setModel(modelStudent);
			    boxAddStudentToCourse.repaint();
			    boxAddStudentToCourse.updateUI();
			    ///////////////
///////////////////
				    tableUpdate();
				    //////
			    JOptionPane.showMessageDialog(null, "Student Deleted Successfully!");
			    
				
			}
	    	
	    });
	    
	    fr103.add(jbtDeleteStudentTotally);
	    
	    boxAddStudentToCourse = new JComboBox<String>();
modelStudent = new DefaultComboBoxModel<String>();
	    
	    ArrayList<String> listTemp5 = sm.getStudentList();
	    for(int i = 0; i < listTemp5.size(); i++)
	    	modelStudent.addElement(listTemp5.get(i));


	    boxAddStudentToCourse.setModel(modelStudent);
	    boxAddStudentToCourse.repaint();
	    boxAddStudentToCourse.updateUI();
	    
	    
	    boxCourseForStudentToAdd = new JComboBox<String>();
	    modelCourse = new DefaultComboBoxModel<String>();
	    
	    ArrayList<String> listTemp6 = cm.getCourseList();
	    for(int i = 0; i < listTemp6.size(); i++)
	    	modelCourse.addElement(listTemp6.get(i));


	    boxCourseForStudentToAdd.setModel(modelCourse);
	    boxCourseForStudentToAdd.repaint();
	    boxCourseForStudentToAdd.updateUI();
	    
	    jbtAddStudentToCourse = new JButton("Add Student to Course");
	    jbtAddStudentToCourse.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String s = (String)boxCourseForStudentToAdd.getSelectedItem();
				
				
				String s0 = (String)boxAddStudentToCourse.getSelectedItem();
				
				if(s == null||s == ""||s0 == null||s0 == "")
				{
					JOptionPane.showMessageDialog(null, "Null add!");
					return;
				}
				
				ArrayList<String> list = cm.getStudentsFromCourse(s.substring(0, s.indexOf(" ")));
				
				String sId = s0.substring(0, s0.indexOf(" "));
			for(int i = 0;i < list.size();i++)
			{
				String sTemp = list.get(i);
				if(sTemp.substring(0, sTemp.indexOf(" ")).equals(sId))
				{
					JOptionPane.showMessageDialog(null, "("+s0+") is already on the list of ("+s+"), Please choose another one");
				return;
				}
				}
			
			cm.addStudentToCourse(sId, s0.substring(s0.indexOf(" ")+1), s.substring(0, s.indexOf(" ")));
			///////////////////////
			modelStudent = new DefaultComboBoxModel<String>();
		    String ss = (String)boxCourse.getSelectedItem();
		    ArrayList<String> listTemp4 = cm.getStudentsFromCourse(ss.substring(0, ss.indexOf(" ")));
		    for(int i = 0;i < listTemp4.size();i++)
		    	modelStudent.addElement(listTemp4.get(i));
		    
		    boxStudent.setModel(modelStudent);
		    boxStudent.repaint();
		    boxStudent.updateUI();
		    ////////////////////////////////////
///////////////////
			    tableUpdate();
			    //////
		    JOptionPane.showMessageDialog(null, "Student Added to"+(String)boxCourseForStudentToAdd.getSelectedItem()+" Successfully!");
		    
			}
	    	
	    });
	    
	    
	    fr103.add(new JLabel(" "));
	    fr103.add(new JLabel(" "));
	   
	    fr103.add(boxAddStudentToCourse);
	    fr103.add(boxCourseForStudentToAdd);
	    fr103.add(jbtAddStudentToCourse);
	    		
	    
	    
	    
	    fr10.add(new JLabel());
	    fr10.add(fr101);
	    fr10.add(new JLabel());
	    fr10.add(fr102);
	    fr10.add(new JLabel());
	    fr10.add(fr103);
	    desktop.add(fr10, BorderLayout.NORTH);
	    
	    
	    getContentPane().add(desktop);
	    setVisible(true);
	}
	


public void tableUpdate()
{
	 DefaultTableModel tableModel = new DefaultTableModel();
	    Vector<String> columnIdentifiers = new Vector<String>();
	    columnIdentifiers.add("Id");
	    columnIdentifiers.add("Name");
	    columnIdentifiers.add("Apr.1");
	    columnIdentifiers.add("Apr.2");
	    columnIdentifiers.add("Apr.3");
	    columnIdentifiers.add("Apr.4");
	    columnIdentifiers.add("Apr.5");
	    columnIdentifiers.add("Apr.6");
	    
	    String s = (String)box0.getSelectedItem();
	    tableModel.setDataVector(cm.getWhole(s.substring(0, s.indexOf(" "))), columnIdentifiers);
	    table.setModel(tableModel);
	   
	    
	    
		 table.repaint();
		    table.updateUI();
}
}