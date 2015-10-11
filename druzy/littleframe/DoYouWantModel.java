package druzy.littleframe;

import java.beans.PropertyChangeEvent;

import druzy.mvc.AbstractModel;

public class DoYouWantModel extends AbstractModel {

	private Runnable ok=null;
	private Runnable cancel=new Runnable(){
		public void run(){
			setExit(true);
		}
	};
	private boolean exit=false;
	
	public DoYouWantModel(Runnable ok) {
		super();
		this.ok=ok;
	}
	
	public DoYouWantModel(Runnable ok, Runnable cancel){
		this(ok);
		this.cancel=cancel;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		boolean old=this.exit;
		this.exit = exit;
		firePropertyChange(new PropertyChangeEvent(this,"exit",old,exit));
	}

	public Runnable getOk() {
		return ok;
	}

	public void setOk(Runnable ok) {
		Runnable old=this.ok;
		this.ok = ok;
		firePropertyChange(new PropertyChangeEvent(this,"ok",old,ok));
	}

	public Runnable getCancel() {
		return cancel;
	}

	public void setCancel(Runnable cancel) {
		Runnable old=this.cancel;
		this.cancel = cancel;
		firePropertyChange(new PropertyChangeEvent(this,"cancel",old,cancel));
	}
	
	

}
