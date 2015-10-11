package druzy.littleframe;
import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileFilter;

import druzy.mvc.AbstractModel;


public class AskFilesModel extends AbstractModel {

	public static final int APPROVE=0;
	
	private List<File> choosenFiles=null;
	private FileFilter filter=null;
	
	public AskFilesModel(FileFilter filter) {
		super();
		
		this.filter=filter;
		this.choosenFiles=new ArrayList<File>();
	}
	
	public void setChoosenFile(File file){
		setChoosenFile(choosenFiles.size(),file);
	}
	
	public void setChoosenFile(File[] files){
		for (int i=0;i<files.length;i++){
			setChoosenFile(files[i]);
		}
	}
	
	public void setChoosenFile(int i,File file){
		choosenFiles.add(i,file);
		firePropertyChange(new IndexedPropertyChangeEvent(this,"choosenFiles",null,file,i));
	}
	
	public List<File> getChoosenFiles(){return choosenFiles;}

	public FileFilter getFilter() {
		return filter;
	}

	public void setFilter(FileFilter filter) {
		FileFilter old=this.filter;
		this.filter = filter;
		firePropertyChange(new PropertyChangeEvent(this,"filter",old,filter));
	}

}
