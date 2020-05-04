package tr.com.melihhilmiuludag.student.proj.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * @author muludag on 2.05.2020
 */
@ManagedBean(name = "pageView")
@SessionScoped
@Component
@Scope("view-screen")
public class PageView implements Serializable {

	private static final long serialVersionUID = -7740534434925479730L;

	@PostConstruct
	public void init() {

	}
	public String create(){
		return "create?faces-redirect=true";
	}

	public String readupdatedelete(){
		return "readupdatedelete?faces-redirect=true";
	}
	public String fileupload(){
		return "fileupload?faces-redirect=true";
	}

}
