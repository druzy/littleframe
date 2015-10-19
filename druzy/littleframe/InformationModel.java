package druzy.littleframe;

import java.io.File;

import druzy.mvc.AbstractModel;
import druzy.utils.FileUtils;

public class InformationModel extends AbstractModel {

	private String information=null;
	
	public InformationModel(String information) {
		super();
		this.information=information;
	}
	
	public InformationModel(File file){
		this(FileUtils.getText(file));
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

}
