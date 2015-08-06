<%@ page session="false" %>
<%@page import="com.wxly.basic.monitor.Monitor" %><%@
page import="java.util.Map.Entry"%><%@ page import="com.qunar.flight.qmonitor.QMonitor"%><%@ page contentType="text/plain;charset=UTF-8" language="java" %><%

for (Entry<String, Long> entry : QMonitor.getValues().entrySet()) {
	String name = entry.getKey();
	Long value = entry.getValue();
	out.append(name + "=" + value + "\n");
}
%>