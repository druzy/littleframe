package druzy.littleframe;
import java.io.File;

import javax.swing.filechooser.FileFilter;

import druzy.mvc.AbstractController;
import druzy.mvc.Model;
import druzy.mvc.View;


public class AskFiles extends AbstractController {

	public AskFiles(Model model) {
		super(model);
		this.addView(new AskFilesView(this));
	}
	
	public AskFiles(FileFilter filter){
		this(new AskFilesModel(filter));
		
	}

	@Override
	public void notifyAction(View view, Object[] info, int action) {
		switch(action){
		case AskFilesModel.APPROVE:
			if (info instanceof File[]){
				File[] files=(File[])info;
				getModel().setChoosenFile(files);
			}
			break;
		}
	}
	
	@Override
	public AskFilesModel getModel(){return (AskFilesModel)super.getModel();}

}
