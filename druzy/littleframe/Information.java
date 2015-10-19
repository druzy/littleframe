package druzy.littleframe;

import java.io.File;

import druzy.mvc.AbstractController;
import druzy.mvc.Model;
import druzy.mvc.View;

public class Information extends AbstractController {

	public Information(Model model) {
		super(model);
		this.addView(new InformationView(this));
	}
	
	public Information(String information){
		this(new InformationModel(information));
	}
	
	public Information(File file){
		this(new InformationModel(file));
	}
	
	@Override
	public void notifyAction(View view, Object[] info, int action) {

	}
	
	@Override
	public InformationModel getModel(){return (InformationModel)super.getModel();}

}
