package servlet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * 图像校验码 * 
 */
public class AuthImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

private static final String CONTENT_TYPE = "text/html;charset=utf-8";

// 设置字体和字号
private Font mFont = new Font("Times New Roman", Font.PLAIN, 17);
 // 生成随机颜色
 Color getRandColor(int fc, int bc) {
  Random random = new Random();
  if (fc > 255)
   fc = 255;
  if (bc > 255)
   bc = 255;
  int r = fc + random.nextInt(bc - fc);
  int g = fc + random.nextInt(bc - fc);
  int b = fc + random.nextInt(bc - fc);
  return new Color(r, g, b);
 }

 // 生成随机字符
 private String getRandChar() {
  int rand = (int) Math.round(Math.random() * 2);
  long item = 0;
  char ctmp;
  // 根据rand的值决定是生成一个大写字母、小写字母还是数字
  
  switch (rand) {
  // 生成大写字母
  case 1:
   item = Math.round(Math.random() * 25 + 65);
   ctmp = (char) item;
   return String.valueOf(ctmp);
   // 生成小写字母
  case 2:
   item = Math.round(Math.random() * 25 + 97);
   ctmp = (char) item;
   return String.valueOf(ctmp);
   // 生成数字
  default:
   item = Math.round(Math.random() * 9);
   ctmp = (char) item;
   return String.valueOf(item);
  }
 }
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
   throws ServletException, IOException {
  // TODO Auto-generated method stub
  // 清除缓存
  resp.setHeader("Pragma", "No-cache");
  resp.setHeader("Cache-Control", "no-cache");
  resp.setDateHeader("Expire", 0);
  // 表明生成的响应的是图片
  resp.setContentType("image/jpeg");
  // 指定验证码图片的大小
  int width = 150;
  int height = 50;
  // 生成一张新图片
  BufferedImage image = new BufferedImage(width, height,
    BufferedImage.TYPE_INT_RGB);
  // 绘制图片边框
  Graphics g = image.getGraphics();
  Random random = new Random();
  g.setColor(getRandColor(200, 250));
  g.fillRect(0, 0, width, height);//
  g.setColor(new Color(102, 102, 102, 102));
  g.drawRect(0, 0, 0, 0);
  g.setFont(mFont);
  // 随机生成线条，让图片看起来更加杂乱
  g.setColor(getRandColor(160, 200));

  for (int i = 0; i < 155; i++) {
   int x1 = random.nextInt(width - 1);
   int y1 = random.nextInt(height - 1);
   int x2 = random.nextInt(6) + 1;
   int y2 = random.nextInt(12) + 1;
   g.drawLine(x1, y1, x2 + x1, y2 + y1);
  }

  // 从另一方向画随机线
  for (int i = 0; i < 80; i++) {
   int x1 = random.nextInt(width - 1);
   int y1 = random.nextInt(height - 1);
   int x2 = random.nextInt(6) + 1;
   int y2 = random.nextInt(12) + 1;
   g.drawLine(x1, y1, x1 - x2, y1 - y2);
  }

  // 生成随机数，并将随机数转化成字母
  String sRand = "";
  for (int i = 0; i < 4; i++) {

   // 取得一个随机字符
   String temp = getRandChar();
   System.out.println("temp:"+temp);
   sRand += temp;
   
   // 将系统生成的随机字符添加到图形验证码图片上
   g.setColor(new Color(20 + random.nextInt(110), 20 + random
     .nextInt(110), 20 + random.nextInt(110)));
   g.setFont(new Font("宋体",Font.BOLD,30)); // 设置字体和字号
   g.drawString(String.valueOf(temp), 30 * i +15, 30+i);// 设置字体绘制位置
   
  }
  //将验证码保存在session中
     HttpSession session=req.getSession(true);
     session.setAttribute("Val", sRand);
     System.out.println(sRand);
     g.dispose();
     //输出图形验证码
     ImageIO.write(image, "JPEG", resp.getOutputStream());
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
   throws ServletException, IOException {
  // TODO Auto-generated method stub
  doGet(req, resp);
 }

}