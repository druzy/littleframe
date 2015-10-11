package druzy.littleframe;
import druzy.mvc.AbstractController;
import druzy.mvc.Model;
import druzy.mvc.View;


public class About extends AbstractController {

	public About(Model model) {
		super(model);
		this.addView(new AboutView(this));
	}

	@Override
	public void notifyAction(View view, Object[] info, int action) {

	}

}
