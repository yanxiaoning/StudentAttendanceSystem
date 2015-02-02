package sas;

import java.io.File;
import java.io.IOException;

import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Recorder {
	private String path = "res/";
	public void inputOrModifyAttendenceData(String cId,String sId,String date,String attendance)
	{
		File file = new File(path+"courses/");
		File[] files = file.listFiles();
		File fileOri = null;
		for(int i = 0;i < files.length;i++)
		{
			if(files[i].getName().contains(cId))
				fileOri = files[i];
		}
		
		
		File fileTemp = new File("res/courses/temp.xls");
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(fileOri);
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableWorkbook copy = null;
		try {
			copy = Workbook.createWorkbook(fileTemp,workbook);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WritableSheet sheet2 = copy.getSheet(0); 
		
		
		int i = 1;
		while(true)
		{
			if(sheet2.getCell(0, i).getContents().equals(sId))
			break;
			else
			i++;
		}
		
		int j = 1;
		while(true)
		{
			if(sheet2.getCell(j, 0).getContents().equals(date))
			break;
			else
			j++;
		}
		System.out.println("over");
		WritableCell cTemp = sheet2.getWritableCell(j, i);
		if(cTemp.getType() == CellType.EMPTY)
		{
			System.out.println("empty");
			try {
				sheet2.addCell(new Label(j,i,attendance));
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("empty over");
		}
		else
		{
			System.out.println("label");
			Label l = (Label)cTemp; 
			  l.setString(attendance);
			  System.out.println("label over");
		}
		
		try {
 			copy.write(); 
 			copy.close();
			workbook.close();
			fileOri.delete();
			fileTemp.renameTo(new File(path+"courses/"+cId+".xls"));
			
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
