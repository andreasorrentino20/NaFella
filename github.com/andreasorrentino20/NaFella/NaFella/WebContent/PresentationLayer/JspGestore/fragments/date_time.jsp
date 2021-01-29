<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
Calendar cal = Calendar.getInstance();
Date dat = new Date();
int gg = dat.getDay();
String giorno = null;
if (gg == 1) {
	giorno = "Monday";
	} else if (gg == 2) {
		giorno = "Tusday";
	} else if (gg == 3) {
		giorno = "Wednesday";
	} else if (gg == 4) {
		giorno = "Thusday";
	} else if (gg == 5) {
		giorno = "Friday";
	} else if (gg == 6) {
		giorno = "Saturday";
	} else if (gg == 0) {
		giorno = "Sunday";
	}

String day = null;

if(cal.get(Calendar.DATE)<10)
	day = "0"+cal.get(Calendar.DATE);
else
	day = ""+cal.get(Calendar.DATE);

String month = null;

if(cal.get(Calendar.MONTH)<10)
	month = "0"+(cal.get(Calendar.MONTH)+1);
else
	month = ""+(cal.get(Calendar.MONTH)+1);

String hour = null;

if(dat.getHours()<10)
	hour = "0"+dat.getHours();
else
	hour = ""+dat.getHours();

String minute = null;

if(dat.getMinutes()<10)
	minute = "0"+dat.getMinutes();
else
	minute = ""+dat.getMinutes();

String second = null;

if(dat.getSeconds()<10)
	second = "0"+dat.getSeconds();
else
	second = ""+dat.getSeconds();

String data_corr= giorno + ", " +day+ "/" + month + "/" + cal.get(Calendar.YEAR);

String ora_corr = hour + ":" + minute + ":" + second;

String time_user_logged = data_corr + " " + ora_corr;
%>