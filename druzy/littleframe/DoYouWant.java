package druzy.littleframe;

import druzy.mvc.AbstractController;
import druzy.mvc.Model;
import druzy.mvc.View;

public class DoYouWant extends AbstractController {

	public DoYouWant(Runnable runnable){
		this(new DoYouWantModel(runnable));
	}
	
	public DoYouWant(Model model) {
		super(model);
	}

	@Override
	public void notifyAction(View view, Object[] info, int action) {
		// TODO Auto-generated method stub

	}

}
