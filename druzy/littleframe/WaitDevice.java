package druzy.littleframe;
import druzy.mvc.AbstractController;
import druzy.mvc.Model;
import druzy.mvc.View;


public class WaitDevice extends AbstractController {

	public WaitDevice(){
		this(new WaitDeviceModel());
	}
	
	public WaitDevice(Model model) {
		super(model);
		this.addView(new WaitDeviceView(this));
	}

	@Override
	public void notifyAction(View view, Object[] info, int action) {
		// TODO Auto-generated method stub

	}

}
