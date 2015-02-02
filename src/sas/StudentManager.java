package sas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class StudentManager {
	private String path = "res/";
	public void initialize()
	{
File newFile = new File(path+"students.xls");
		
		
		
		
		
		
		
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(newFile);
			WritableSheet sheet = workbook.createSheet("mySheet", 0);

            
			
			Label r1 = new Label(0, 1, "001001");
			Label r2 = new Label(0, 2, "001002");
			Label r3 = new Label(0, 3, "001003");
			Label r4 = new Label(0, 4, "001004");
			Label r5 = new Label(0, 5, "001005");
			Label r6 = new Label(0, 6, "001006");
			Label r7 = new Label(0, 7, "001007");
			
			
			Label r9 = new Label(1, 1, "Eric Franklin");
			Label r10 = new Label(1, 2, "Lindsay Zhang");
			Label r11 = new Label(1, 3, "Steven Poe");
			Label r12 = new Label(1, 4, "John Lin");
			Label r13 = new Label(1, 5, "Wendy Spacey");
			Label r14 = new Label(1, 6, "Kevin Smith");
			Label r15 = new Label(1, 7, "Paul Norton");
			
			Label r00 = new Label(0, 0, "7");
			
			sheet.addCell(r1);
			sheet.addCell(r2);
			sheet.addCell(r3);
			sheet.addCell(r4);
			sheet.addCell(r5);
			sheet.addCell(r6);
			sheet.addCell(r7);
			sheet.addCell(r9);
			sheet.addCell(r10);
			sheet.addCell(r11);
			sheet.addCell(r12);
			sheet.addCell(r13);
			sheet.addCell(r14);
			sheet.addCell(r15);
			sheet.addCell(r00);
			
			
			
			workbook.write();
	 		workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(String sId)
	{
try {
			
			
			
	        File fileOri  = new File("res/students.xls");
			File fileTemp = new File("res/temp.xls");
			
			Workbook workbook = Workbook.getWorkbook(fileOri);
			WritableWorkbook copy=Workbook.createWorkbook(fileTemp,workbook);
			
			
			WritableSheet sheet2 = copy.getSheet(0); 
			
		    	Cell cCount = sheet2.getCell(0, 0);
		    	int count = Integer.parseInt(cCount.getContents());
		    	
		    	int i;
			for(i = 1;i < count+1;i++)
			{
				if(sheet2.getCell(0, i).getContents().equals(sId))
					break;
			}
			
			for(int j = 0;j < 2;j++)
			{
				WritableCell c = sheet2.getWritableCell(j,i);
				if (c.getType() == CellType.LABEL) 
				{ 
				  Label l = (Label)c; 
				  l.setString("");
				}
			}
			
			System.out.println(i);
			
			
			
	 		try {
	 			copy.write(); 
	 			copy.close();
				workbook.close();
				fileOri.delete();
				fileTemp.renameTo(new File(path+"students.xls"));
				
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



File file = new File(path+"courses/");
File[] files = file.listFiles();


CourseManager cm = new CourseManager();
for(int i = 0;i < files.length;i++)
{
	String s = files[i].getName();
	cm.deleteStudentFromCourse(sId, s.substring(0,s.indexOf(".")));
		
}


	}
	
	public void addStudent(String sId,String sName)
	{
try {
			
			
			
			
			File fileTemp = new File("res/temp.xls");
			File fileOri  = new File("res/students.xls");;
			Workbook workbook = Workbook.getWorkbook(fileOri);
			WritableWorkbook copy=Workbook.createWorkbook(fileTemp,workbook);
			
			
			WritableSheet sheet2 = copy.getSheet(0); 
			
		    	Cell cCount = sheet2.getCell(0, 0);
		    	int count = Integer.parseInt(cCount.getContents());
		    	
		    	
			/////////////////////////////
		    	WritableCell c = sheet2.getWritableCell(0,0);
				if (c.getType() == CellType.LABEL) 
				{ 
				  Label l = (Label)c; 
				  l.setString(String.valueOf(count+1));
				}
		    	
				Label lsid = new Label(0,count + 1,sId);
				Label lsname = new Label(1,count + 1,sName);
				
				
				try {
					sheet2.addCell(lsid);
					sheet2.addCell(lsname);
					
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    	//////////////////////////////
			
			
			
			
	 		try {
	 			copy.write(); 
	 			copy.close();
				workbook.close();
				fileOri.delete();
				fileTemp.renameTo(new File(path+"students.xls"));
				
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	public ArrayList<String> getStudentList()
	{
		
File newFile = new File(path+"students.xls");
		
		
		
ArrayList<String> list = new ArrayList<String>();
		
		
		
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(newFile);
			Sheet sheet = workbook.getSheet(0);
			Cell cell = sheet.getCell(0, 0);
			int count = Integer.parseInt(cell.getContents());
			
			
			
			for(int i = 0;i<count;i++)
			{
				Cell cellTemp = sheet.getCell(1, i + 1);
				Cell cellTemp2 = sheet.getCell(0, i + 1);
				if(cellTemp.getType() != CellType.EMPTY&&!cellTemp.getContents().equals(null)&&!cellTemp.getContents().equals(""))
					list.add(cellTemp2.getContents()+" "+cellTemp.getContents());
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Ex");
		}
		/*
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
			*/
		return list;
	}
}
