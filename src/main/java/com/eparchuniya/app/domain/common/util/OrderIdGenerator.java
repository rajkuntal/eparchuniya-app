package com.eparchuniya.app.domain.common.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGenerator implements IdentifierGenerator{

	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
	    DateFormat timeFormat = new SimpleDateFormat("HHmmssSS");
	    Date currentDate = new Date();
	    String orderId = "EPO-"+timeFormat.format(currentDate).toString()+"-"+dateFormat.format(currentDate).toString();
	    
	    return orderId;
	}
}
