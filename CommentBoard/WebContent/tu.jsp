<%@page import="java.awt.Font"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
    <%@ page contentType="image/jpeg" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>画图</title>
</head>
<body>
	<%
		BufferedImage image = new BufferedImage(340,160,BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.fillRect(0, 0, 400, 400);
		graphics.setColor(new Color(255,0,0));
		graphics.fillArc(20, 20, 100, 100, 30, 120);
		graphics.setColor(new Color(0,255,0));
		graphics.fillArc(20, 20, 100, 100, 150, 120);
		graphics.setColor(new Color(0,0,255));
		graphics.fillArc(20, 20, 100, 100, 270, 120);
		graphics.setColor(new Color(0,0,0));
		graphics.setFont(new Font("Arial Black", Font.PLAIN, 16));
		graphics.drawString("red:climb", 200, 60);
		graphics.drawString("green:swim", 200, 100);
		graphics.drawString("blue:jump", 200, 140);
		graphics.dispose();
		
		
		
		ImageIO.write(image, "jpeg", response.getOutputStream());
	%>
</body>
</html>