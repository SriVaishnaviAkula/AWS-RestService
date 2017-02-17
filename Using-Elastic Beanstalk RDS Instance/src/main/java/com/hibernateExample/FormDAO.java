package com.hibernateExample;

import java.util.List;
import com.hibernateExample.model.SessionUtil;
import com.hibernateExample.Form;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public class FormDAO {

		public List<Form> getForm(){
			System.out.println("get form");
	        Session session = SessionUtil.getSession();    
	        Query query = session.createQuery("from Form");
	        List<Form> form =  query.list();
	        session.close();
	        return form;
	    }

	    public void addForm(Form bean){
	        Session session = SessionUtil.getSession();        
	        Transaction tx = session.beginTransaction();
	        addForm(session, bean);        
	        tx.commit();
	        session.close();
	        
	    }
	    
	    private void addForm(Session session, Form bean){
	        Form frm = new Form();
	        frm.setName(bean.getName());
	        frm.setAddress(bean.getAddress());
	        frm.setEmail(bean.getEmail());
	        frm.setSig(bean.getSig());
	        session.save(frm);
	    }
	}

	 