package sas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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

public class CourseManager {
	private String path = "res/";

	public void deleteCourse(String cId)
	{
		File file = new File(path+"courses/");
		File[] files = file.listFiles();
		for(int k = 0;k < files.length;k++)
		{
			if(files[k].getName().contains(cId))
			{
				files[k].delete();
			break;
			}
		}
		
		///////////////////////////
try {
			
			
			
			File fileTemp = new File("res/temp.xls");
			File fileOri = new File("res/courses.xls");;
			Workbook workbook = Workbook.getWorkbook(fileOri );
			WritableWorkbook copy=Workbook.createWorkbook(fileTemp,workbook);
			
			
			WritableSheet sheet2 = copy.getSheet(0); 
			
		    	Cell cCount = sheet2.getCell(0, 0);
		    	int count = Integer.parseInt(cCount.getContents());
		    	
		    	int i;
			for(i = 1;i < count+1;i++)
			{
				if(sheet2.getCell(0, i).getContents().equals(cId))
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
				fileTemp.renameTo(new File(path+"courses.xls"));
				
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
		//////////////////////////
		
		
	}
	
	public void addCourse(String cId,String cName)
	{
		
		/////////////////////////////////////
try {
			
			
			
			File fileTemp = new File("res/temp.xls");
			File fileOri = new File("res/courses.xls");
			Workbook workbook = Workbook.getWorkbook(fileOri );
			WritableWorkbook copy=Workbook.createWorkbook(fileTemp,workbook);
			
			
			WritableSheet sheet2 = copy.getSheet(0); 
			
		    	Cell cCount = sheet2.getCell(0, 0);
		    	int count = Integer.parseInt(cCount.getContents());
		    	
		    	WritableCell c = sheet2.getWritableCell(0,0);
				if (c.getType() == CellType.LABEL) 
				{ 
				  Label l = (Label)c; 
				  l.setString(String.valueOf(count+1));
				}
		    	
				Label lcid = new Label(0,count + 1,cId);
				Label lcName = new Label(1,count + 1,cName);
				
				try {
					sheet2.addCell(lcid);
					sheet2.addCell(lcName);
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
		    
		    	
			
			
			
			
			
	 		try {
	 			copy.write(); 
	 			copy.close();
				workbook.close();
				fileOri.delete();
				fileTemp.renameTo(new File(path+"courses.xls"));
				
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
		////////////////////////////////////
		
		
		File file = new File(path);
		File[] files = file.listFiles();
		for(int i = 0;i < files.length;i++)
		{
			if(files[i].getName().contains(cId))
				return;
		}
		
		File newFile = new File(path+"courses/"+cId+".xls");
		
		
		
			
			
			
				
			WritableWorkbook workbook;
			try {
				workbook = Workbook.createWorkbook(newFile);
				WritableSheet sheet = workbook.createSheet("mySheet", 0);

	            
				
				Label r1 = new Label(2, 0, "4.1");
				Label r2 = new Label(3, 0, "4.2");
				Label r3 = new Label(4, 0, "4.3");
				Label r4 = new Label(5, 0, "4.4");
				Label r5 = new Label(6, 0, "4.5");
				Label r6 = new Label(7, 0, "4.6");
				
				
				sheet.addCell(r1);
				sheet.addCell(r2);
				sheet.addCell(r3);
				sheet.addCell(r4);
				sheet.addCell(r5);
				sheet.addCell(r6);
				
				Label r00 = new Label(0, 0, "0");
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
	
	public void deleteStudentFromCourse(String sId,String cId)
	{
		try {
			
			File file = new File(path+"courses/");
			File[] files = file.listFiles();
			File fileOri = null;
			for(int i = 0;i < files.length;i++)
			{
				if(files[i].getName().contains(cId))
				{
					fileOri = files[i];
					System.out.println(files[i].getName());
				}
			}
			
			
			File fileTemp = new File("res/courses/temp.xls");
			Workbook workbook = Workbook.getWorkbook(fileOri);
			WritableWorkbook copy=Workbook.createWorkbook(fileTemp,workbook);
			
			
			WritableSheet sheet2 = copy.getSheet(0); 
			
		    	Cell cCount = sheet2.getCell(0, 0);
		    	int count = Integer.parseInt(cCount.getContents());
		    	
		    	int i;
			for(i = 1;i < count+1;i++)
			{
				if(sheet2.getCell(0, i).getContents().equals(sId))
				{
					for(int j = 0;j < 8;j++)
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
						fileTemp.renameTo(new File(path+"courses/"+cId+".xls"));
						return;
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}
			System.out.println("!!!!!!!!!!!!!!!!!!!");
			copy.write(); 
 			try {
				copy.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			workbook.close();
			fileOri.delete();
			fileTemp.renameTo(new File(path+"courses/"+cId+".xls"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void addStudentToCourse(String sId, String sName,String cId)
	{
try {
			
			File file = new File(path+"courses/");
			File[] files = file.listFiles();
			File fileOri = null;
			for(int i = 0;i < files.length;i++)
			{
				if(files[i].getName().contains(cId))
					fileOri = files[i];
			}
			
			
			File fileTemp = new File("res/courses/temp.xls");
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
				fileTemp.renameTo(new File(path+"courses/"+cId+".xls"));
				
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
	
	
	
	
	public void initialize()
	{
	File file = new File("res/courses");
	file.mkdir();
		initialize1();
		initialize2();
		initializeCourses();
	}
	
	public void initialize1()
	{
		File newFile = new File(path+"courses/"+"6301"+".xls");
		
		
		
		
		
		
		
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(newFile);
			WritableSheet sheet = workbook.createSheet("mySheet", 0);

            
			
			Label r1 = new Label(2, 0, "4.1");
			Label r2 = new Label(3, 0, "4.2");
			Label r3 = new Label(4, 0, "4.3");
			Label r4 = new Label(5, 0, "4.4");
			Label r5 = new Label(6, 0, "4.5");
			Label r6 = new Label(7, 0, "4.6");
			
			
			sheet.addCell(r1);
			sheet.addCell(r2);
			sheet.addCell(r3);
			sheet.addCell(r4);
			sheet.addCell(r5);
			sheet.addCell(r6);
			
			Label c1 = new Label(0, 1, "001003");
			Label c2 = new Label(0, 2, "001004");
			Label c3 = new Label(0, 3, "001005");
			Label c4 = new Label(0, 4, "001006");
			Label c5 = new Label(0, 5, "001007");
			
			
			
			Label c1r = new Label(1, 1, "Steven Poe");
			Label c2r = new Label(1, 2, "John Lin");
			Label c3r = new Label(1, 3, "Wendy Spacey");
			Label c4r = new Label(1, 4, "Kevin Smith");
			Label c5r = new Label(1, 5, "Paul Norton");
			
			
			
			sheet.addCell(c1);
			sheet.addCell(c2);
			sheet.addCell(c3);
			sheet.addCell(c4);
			sheet.addCell(c5);
			
			sheet.addCell(c1r);
			sheet.addCell(c2r);
			sheet.addCell(c3r);
			sheet.addCell(c4r);
			sheet.addCell(c5r);
			
			Label c11 = new Label(2, 1, "attend");
			Label c12 = new Label(3, 1, "attend");
			Label c13 = new Label(4, 1, "attend");
			Label c14 = new Label(5, 1, "attend");
			//Label c15 = new Label(6, 1, "0");
			//Label c16 = new Label(7, 1, "0");
			
			
			
			sheet.addCell(c11);
			sheet.addCell(c12);
			sheet.addCell(c13);
			sheet.addCell(c14);
			//sheet.addCell(c15);
			//sheet.addCell(c16);
			
			Label c21 = new Label(2, 2, "attend");
			Label c22 = new Label(3, 2, "attend");
			Label c23 = new Label(4, 2, "attend");
			Label c24 = new Label(5, 2, "ABSENT");
			//Label c25 = new Label(6, 2, "0");
			//Label c26 = new Label(7, 2, "1");
			
			
			
			sheet.addCell(c21);
			sheet.addCell(c22);
			sheet.addCell(c23);
			sheet.addCell(c24);
			//sheet.addCell(c25);
			//sheet.addCell(c26);
			
			Label c31 = new Label(2, 3, "attend");
			Label c32 = new Label(3, 3, "attend");
			Label c33 = new Label(4, 3, "ABSENT");
			Label c34 = new Label(5, 3, "ABSENT");
			//Label c35 = new Label(6, 3, "1");
			//Label c36 = new Label(7, 3, "1");
			
			
			
			sheet.addCell(c31);
			sheet.addCell(c32);
			sheet.addCell(c33);
			sheet.addCell(c34);
			//sheet.addCell(c35);
			//sheet.addCell(c36);
			
			Label c41 = new Label(2, 4, "attend");
			Label c42 = new Label(3, 4, "ABSENT");
			Label c43 = new Label(4, 4, "ABSENT");
			Label c44 = new Label(5, 4, "attend");
			//Label c45 = new Label(6, 4, "1");
			///Label c46 = new Label(7, 4, "1");
			
			
			
			sheet.addCell(c41);
			sheet.addCell(c42);
			sheet.addCell(c43);
			sheet.addCell(c44);
			//sheet.addCell(c45);
			//sheet.addCell(c46);
			
			
			Label c51 = new Label(2, 5, "ABSENT");
			Label c52 = new Label(3, 5, "ABSENT");
			Label c53 = new Label(4, 5, "attend");
			Label c54 = new Label(5, 5, "attend");
			//Label c55 = new Label(6, 5, "1");
			//Label c56 = new Label(7, 5, "1");
			
			
			
			sheet.addCell(c51);
			sheet.addCell(c52);
			sheet.addCell(c53);
			sheet.addCell(c54);
			//sheet.addCell(c55);
			//sheet.addCell(c56);
			
			Label c00 = new Label(0, 0, "5");
			sheet.addCell(c00);
			
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
	
	
	public void initialize2()
	{
	File newFile = new File(path+"courses/"+"6363"+".xls");
		
		
		
		
		
		
		
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(newFile);
			WritableSheet sheet = workbook.createSheet("mySheet", 0);

            
			
			Label r1 = new Label(2, 0, "4.1");
			Label r2 = new Label(3, 0, "4.2");
			Label r3 = new Label(4, 0, "4.3");
			Label r4 = new Label(5, 0, "4.4");
			Label r5 = new Label(6, 0, "4.5");
			Label r6 = new Label(7, 0, "4.6");
			
			
			sheet.addCell(r1);
			sheet.addCell(r2);
			sheet.addCell(r3);
			sheet.addCell(r4);
			sheet.addCell(r5);
			sheet.addCell(r6);
			
			Label c1 = new Label(0, 1, "001001");
			Label c2 = new Label(0, 2, "001002");
			Label c3 = new Label(0, 3, "001003");
			Label c4 = new Label(0, 4, "001004");
			Label c5 = new Label(0, 5, "001005");
			
			
			
			Label c1r = new Label(1, 1, "Eric Franklin");
			Label c2r = new Label(1, 2, "Lindsay Zhang");
			Label c3r = new Label(1, 3, "Steven Poe");
			Label c4r = new Label(1, 4, "John Lin");
			Label c5r = new Label(1, 5, "Wendy Spacey");
			
			
			
			
			sheet.addCell(c1);
			sheet.addCell(c2);
			sheet.addCell(c3);
			sheet.addCell(c4);
			sheet.addCell(c5);
			
			sheet.addCell(c1r);
			sheet.addCell(c2r);
			sheet.addCell(c3r);
			sheet.addCell(c4r);
			sheet.addCell(c5r);
			
			Label c11 = new Label(2, 1, "attend");
			Label c12 = new Label(3, 1, "attend");
			Label c13 = new Label(4, 1, "attend");
			///Label c14 = new Label(5, 1, "1");
			///Label c15 = new Label(6, 1, "0");
			///Label c16 = new Label(7, 1, "0");
			
			
			
			sheet.addCell(c11);
			sheet.addCell(c12);
			sheet.addCell(c13);
			///sheet.addCell(c14);
			//sheet.addCell(c15);
			//sheet.addCell(c16);
			
			Label c21 = new Label(2, 2, "attend");
			Label c22 = new Label(3, 2, "attend");
			Label c23 = new Label(4, 2, "attend");
			//Label c24 = new Label(5, 2, "0");
			//Label c25 = new Label(6, 2, "0");
			//Label c26 = new Label(7, 2, "1");
			
			
			
			sheet.addCell(c21);
			sheet.addCell(c22);
			sheet.addCell(c23);
			//sheet.addCell(c24);
			//sheet.addCell(c25);
			//sheet.addCell(c26);
			
			Label c31 = new Label(2, 3, "attend");
			Label c32 = new Label(3, 3, "attend");
			Label c33 = new Label(4, 3, "ABSENT");
			//Label c34 = new Label(5, 3, "0");
			//Label c35 = new Label(6, 3, "1");
			//Label c36 = new Label(7, 3, "1");
			
			
			
			sheet.addCell(c31);
			sheet.addCell(c32);
			sheet.addCell(c33);
			//sheet.addCell(c34);
			//sheet.addCell(c35);
			//sheet.addCell(c36);
			
			Label c41 = new Label(2, 4, "attend");
			Label c42 = new Label(3, 4, "ABSENT");
			Label c43 = new Label(4, 4, "ABSENT");
			//Label c44 = new Label(5, 4, "1");
			//Label c45 = new Label(6, 4, "1");
			//Label c46 = new Label(7, 4, "1");
			
			
			
			sheet.addCell(c41);
			sheet.addCell(c42);
			sheet.addCell(c43);
			//sheet.addCell(c44);
			//sheet.addCell(c45);
			//sheet.addCell(c46);
			
			
			Label c51 = new Label(2, 5, "ABSENT");
			Label c52 = new Label(3, 5, "ABSENT");
			Label c53 = new Label(4, 5, "attend");
			//Label c54 = new Label(5, 5, "1");
			//Label c55 = new Label(6, 5, "1");
			//Label c56 = new Label(7, 5, "1");
			
			
			
			sheet.addCell(c51);
			sheet.addCell(c52);
			sheet.addCell(c53);
			//sheet.addCell(c54);
			//sheet.addCell(c55);
			//sheet.addCell(c56);
			
			Label c00 = new Label(0, 0, "5");
			sheet.addCell(c00);
			
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
	
	public void initializeCourses()
	{
File newFile = new File(path+"courses.xls");
		
		
		
		
		
		
		
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(newFile);
			WritableSheet sheet = workbook.createSheet("mySheet", 0);

            
			
			Label r1 = new Label(0, 1, "6301");
			Label r2 = new Label(0, 2, "6363");
			
			
			
			Label r9 = new Label(1, 1, "Information Security");
			Label r10 = new Label(1, 2, "OOAD");
			
			Label r00 = new Label(0, 0, "2");
			
			
			sheet.addCell(r1);
			sheet.addCell(r2);
			
			sheet.addCell(r9);
			sheet.addCell(r10);
			
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
	
	public ArrayList<String> getCourseList()
	{
		
File newFile = new File(path+"courses.xls");
		
		
		
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
				if(cellTemp.getType() != CellType.EMPTY&&!cellTemp.getContents().equals("")&&!cellTemp.getContents().equals(null))
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
	
	public ArrayList<String> getStudentsFromCourse(String cId)
	{
		
		File newFile = new File(path+"courses/"+cId+".xls");
		
		
		
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
						if(cellTemp.getType() != CellType.EMPTY&&!cellTemp.getContents().equals("")&&!cellTemp.getContents().equals(null))
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
	
	public Vector<Vector<String>> getWhole(String cId)
	{
File newFile = new File(path+"courses/"+cId+".xls");
		
		
		
Vector<Vector<String>> list = new Vector<Vector<String>>();
				
				
				
				Workbook workbook;
				try {
					workbook = Workbook.getWorkbook(newFile);
					Sheet sheet = workbook.getSheet(0);
					Cell cell = sheet.getCell(0, 0);
					int count = Integer.parseInt(cell.getContents());
					
					
					
					for(int i = 0;i<count;i++)
					{
						Vector<String> listTemp = new Vector<String>();
						Cell cellTemp = sheet.getCell(0, i + 1);
						
						if(cellTemp.getType() != CellType.EMPTY&&!cellTemp.getContents().equals("")&&!cellTemp.getContents().equals(null))
						{
							for(int j = 0;j < 8;j++)
							{
								Cell cellTempIn = sheet.getCell(j, i + 1);
								if(cellTempIn.getType() != CellType.EMPTY&&!cellTempIn.getContents().equals("")&&!cellTempIn.getContents().equals(null))
						listTemp.add(cellTempIn.getContents());
			                    else
			                    	listTemp.add("");
								}
							
							
							list.add(listTemp);
						
						}
						
						}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				/*
				for(int i=0;i<list.size();i++)
					System.out.println(list.get(i));
					*/
				return list;
		
		
	}
	
	public ArrayList<Integer> getRateList(String cId)
	{
		ArrayList<Integer> rateList = new ArrayList<Integer>();
       Vector<Vector<String>> v = getWhole(cId);
       
       
       for(int i = 0;i < 6;i++)
       {
    	   
    	   System.out.println("count");
    	   int total = 0;
    	   for(int j = 0;j < v.size();j++)
    	   {
    		   
    	   String s = v.get(j).get(i+2);
    	   
    	   if(s != "")
    	   {
    		   
    		   if(s.equals("attend"))
    		   {
   		   total = total + 1;
   		System.out.println("@@");
    		   }
System.out.println("up");
    	   }
    	   else
    	   {
    		   
    		   
    	   }
    	   }
    	   
    	   
    	  
    	   
    	   
    		   rateList.add(total);
    	   
       }
		
		return rateList;
}
	
	
	public void UpdateAttendenceDetailCellTo_Attend(String cId,String sId,int column)
	{
try {
			
			File file = new File(path+"courses/");
			File[] files = file.listFiles();
			File fileOri = null;
			for(int i = 0;i < files.length;i++)
			{
				if(files[i].getName().contains(cId))
				{
					fileOri = files[i];
					System.out.println(files[i].getName());
				}
			}
			
			
			File fileTemp = new File("res/courses/temp.xls");
			Workbook workbook = Workbook.getWorkbook(fileOri);
			WritableWorkbook copy=Workbook.createWorkbook(fileTemp,workbook);
			
			
			WritableSheet sheet2 = copy.getSheet(0); 
			
		    	Cell cCount = sheet2.getCell(0, 0);
		    	int count = Integer.parseInt(cCount.getContents());
		    	
		    	int i;
			for(i = 1;i < count+1;i++)
			{
				if(sheet2.getCell(0, i).getContents().equals(sId))
				{
					WritableCell cell = sheet2.getWritableCell(column, i);
					if (cell.getType() == CellType.LABEL) 
					{ 
					  Label l = (Label)cell; 
					  l.setString("attend");
					}
					else if (cell.getType() == CellType.EMPTY) 
					{ 
						  Label l = new Label(column, i,"attend"); 
						  try {
							sheet2.addCell(l);
						} catch (RowsExceededException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (WriteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
				}
			}
			
			copy.write(); 
 			try {
				copy.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			workbook.close();
			fileOri.delete();
			fileTemp.renameTo(new File(path+"courses/"+cId+".xls"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void UpdateAttendenceDetailCellTo_Absent(String cId,String sId,int column)
	{
try {
			
			File file = new File(path+"courses/");
			File[] files = file.listFiles();
			File fileOri = null;
			for(int i = 0;i < files.length;i++)
			{
				if(files[i].getName().contains(cId))
				{
					fileOri = files[i];
					System.out.println(files[i].getName());
				}
			}
			
			
			File fileTemp = new File("res/courses/temp.xls");
			Workbook workbook = Workbook.getWorkbook(fileOri);
			WritableWorkbook copy=Workbook.createWorkbook(fileTemp,workbook);
			
			
			WritableSheet sheet2 = copy.getSheet(0); 
			
		    	Cell cCount = sheet2.getCell(0, 0);
		    	int count = Integer.parseInt(cCount.getContents());
		    	
		    	int i;
			for(i = 1;i < count+1;i++)
			{
				if(sheet2.getCell(0, i).getContents().equals(sId))
				{
					WritableCell cell = sheet2.getWritableCell(column, i);
					if (cell.getType() == CellType.LABEL) 
					{ 
					  Label l = (Label)cell; 
					  l.setString("ABSENT");
					}
					else if (cell.getType() == CellType.EMPTY) 
					{ 
						  Label l = new Label(column, i,"ABSENT"); 
						  try {
							sheet2.addCell(l);
						} catch (RowsExceededException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (WriteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
				}
			}
			
			copy.write(); 
 			try {
				copy.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			workbook.close();
			fileOri.delete();
			fileTemp.renameTo(new File(path+"courses/"+cId+".xls"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
